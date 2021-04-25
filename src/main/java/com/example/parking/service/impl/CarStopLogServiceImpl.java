package com.example.parking.service.impl;

import com.example.parking.entity.CarStopLog;
import com.example.parking.mapper.CarStopLogMapper;
import com.example.parking.service.ICarStopLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 当前停车场车辆信息 服务实现类
 * </p>
 *
 * @author xy
 * @since 2021-04-24
 */
@Service
public class CarStopLogServiceImpl extends ServiceImpl<CarStopLogMapper, CarStopLog> implements ICarStopLogService {

}
