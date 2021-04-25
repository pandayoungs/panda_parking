package com.example.parking.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.parking.entity.CarStop;
import com.example.parking.entity.CarStopLog;
import com.example.parking.entity.ParkingStatistics;
import com.example.parking.mapper.CarStopLogMapper;
import com.example.parking.mapper.CarStopMapper;
import com.example.parking.mapper.ParkingStatisticsMapper;
import com.example.parking.service.ICarStopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * <p>
 * 当前停车场车辆信息 服务实现类
 * </p>
 *
 * @author xy
 * @since 2021-04-24
 */
@Service
public class CarStopServiceImpl extends ServiceImpl<CarStopMapper, CarStop> implements ICarStopService {

    @Autowired
    private CarStopLogMapper carStopLogMapper;
    @Autowired
    private ParkingStatisticsMapper parkingStatisticsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean carAdmission(CarStop carStop) {
        ParkingStatistics entityByType = parkingStatisticsMapper.getEntityByType(carStop.getType());
        if(null == entityByType){
            throw new RuntimeException("无法识别该车类型");
        }
        if(entityByType.getParkingUsable() <= 0){
            throw new RuntimeException("车位库存不足");
        }
        carStop.setStopDate(LocalDateTime.now());
        carStop.setPrice(entityByType.getPrice());
        carStop.setTotal(entityByType.getTotal());
        this.saveOrUpdate(carStop);
        //停车位库存减一
        ParkingStatistics statistics = new ParkingStatistics();
        statistics.setId(entityByType.getId());
        statistics.setParkingUsable(entityByType.getParkingUsable() - 1);
        parkingStatisticsMapper.updateById(statistics);
        return true;
    }

    @Override
    public BigDecimal costSettlement(String id) {
        CarStop carStop = baseMapper.selectById(id);
        BigDecimal costSum = costSum(carStop);
        return costSum;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean carLeave(CarStopLog carStopLog) {
        CarStop carStop = baseMapper.selectById(carStopLog.getCarId());
        BeanUtils.copyProperties(carStop, carStopLog);
        carStopLog.setId(null);
        carStopLog.setLeaveDate(LocalDateTime.now());
        //插入停车记录
        carStopLogMapper.insert(carStopLog);
        //删除当前车辆
        baseMapper.deleteById(carStopLog.getCarId());
        //空闲车位+1
        parkingStatisticsMapper.usableAdd(carStopLog.getType());
        return true;
    }

    @Override
    public BigDecimal amountOfMoney(LocalDateTime dateTime) {
        BigDecimal bigDecimal = carStopLogMapper.accountByDate(dateTime);
        return bigDecimal;
    }

    /**
     * 获取停车费用
     * @param carStop
     * @return
     */
    private BigDecimal costSum(CarStop carStop){
        LocalDateTime startTime = carStop.getStopDate();
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime tempDateTime = LocalDateTime.from( startTime );
        long days = tempDateTime.until( endTime, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays( days );
        long hours = tempDateTime.until( endTime, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours( hours );
        long minutes = tempDateTime.until( endTime, ChronoUnit.MINUTES);
        if(minutes > 0){
            hours = hours + 1;
        }
        BigDecimal price = carStop.getPrice();
        BigDecimal total = carStop.getTotal();
        BigDecimal decimal = total.multiply(new BigDecimal(days)).add(price.multiply(new BigDecimal(hours)));
        return decimal;
    }
}
