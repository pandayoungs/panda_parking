package com.example.parking.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.parking.entity.CarStop;
import com.example.parking.entity.CarStopLog;
import com.example.parking.service.ICarStopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 当前停车场车辆信息 前端控制器
 * </p>
 *
 * @author xy
 * @since 2021-04-24
 */
@RestController
@RequestMapping("/carStop")
@Api(tags = "当前停车场车辆信息")
public class CarStopController {

    @Autowired
    private ICarStopService carStopService;

    @PostMapping("/carAdmission")
    @ApiOperation(value = "车辆入场接口")
    public R carAdmission(@Validated @RequestBody CarStop carStop){
        return carStopService.carAdmission(carStop) ? R.ok(carStop) : R.failed("入场失败！");
    }

    @PostMapping("/costSettlement")
    @ApiOperation(value = "费用结算")
    public R<BigDecimal> costSettlement(String id){
        return R.ok(carStopService.costSettlement(id));
    }

    @PostMapping("/carLeave")
    @ApiOperation(value = "车辆离场")
    public R carLeave(@Validated @RequestBody CarStopLog carStopLog){
        return carStopService.carLeave(carStopLog) ? R.ok(carStopLog) : R.failed("离场失败！");
    }

    @GetMapping("/amountOfMoney")
    @ApiOperation(value = "当日金额统计-可扩展为任意天金额统计")
    public R amountOfMoney(){
        return R.ok(carStopService.amountOfMoney(LocalDateTime.now()));
    }

}
