package com.example.parking.mapper;

import com.example.parking.entity.ParkingStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 车位统计表 Mapper 接口
 * </p>
 *
 * @author xy
 * @since 2021-04-24
 */
public interface ParkingStatisticsMapper extends BaseMapper<ParkingStatistics> {
    /**
     * 根据类型查询
     * @param type
     * @return
     */
    ParkingStatistics getEntityByType(Integer type);

    /**
     * 可以车位增加
     * @param type
     * @return
     */
    int usableAdd(Integer type);
}
