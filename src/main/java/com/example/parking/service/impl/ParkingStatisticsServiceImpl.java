package com.example.parking.service.impl;

import com.example.parking.entity.ParkingStatistics;
import com.example.parking.mapper.ParkingStatisticsMapper;
import com.example.parking.service.IParkingStatisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车位统计表 服务实现类
 * </p>
 *
 * @author xy
 * @since 2021-04-24
 */
@Service
public class ParkingStatisticsServiceImpl extends ServiceImpl<ParkingStatisticsMapper, ParkingStatistics> implements IParkingStatisticsService {

}
