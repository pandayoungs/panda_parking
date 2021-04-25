package com.example.parking.mapper;

import com.example.parking.entity.CarStopLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 当前停车场车辆信息 Mapper 接口
 * </p>
 *
 * @author xy
 * @since 2021-04-24
 */
public interface CarStopLogMapper extends BaseMapper<CarStopLog> {
    /**
     * 根据日期查询总金额
     * @param dateTime
     * @return
     */
    BigDecimal accountByDate(LocalDateTime dateTime);
}
