package com.example.parking.service;

import com.example.parking.entity.CarStop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.parking.entity.CarStopLog;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 当前停车场车辆信息 服务类
 * </p>
 *
 * @author xy
 * @since 2021-04-24
 */
public interface ICarStopService extends IService<CarStop> {

    /**
     * 车辆入场时登记
     * @param carStop
     * @return
     */
    Boolean carAdmission(CarStop carStop);

    /**
     * 费用结算
     * @param id
     * @return
     */
    BigDecimal costSettlement(String id);

    /**
     * 车辆离场
     * @param carStopLog
     * @return
     */
    Boolean carLeave(CarStopLog carStopLog);

    /**
     *
     * @return
     */
    BigDecimal amountOfMoney(LocalDateTime dateTime);
}
