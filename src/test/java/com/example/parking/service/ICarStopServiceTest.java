package com.example.parking.service;

import com.example.parking.entity.CarStop;
import com.example.parking.entity.CarStopLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICarStopServiceTest {

    @Autowired
    private ICarStopService carStopService;

    /**
     * 入场测试
     */
    @Test
    public void carAdmission() {
        CarStop carStop = new CarStop();
        carStop.setId("川A-123433");
        carStop.setType(1);
        carStopService.carAdmission(carStop);
    }

    /**
     * 缴费金额
     */
    @Test
    public void costSettlement() {
        String id = "川A-123432";
        BigDecimal money = carStopService.costSettlement(id);
        System.out.println("返回参数：" + money);
    }

    /**
     * 离场测试
     */
    @Test
    public void carLeave() {
        CarStopLog carStopLog = new CarStopLog();
        carStopLog.setCarId("川A-123432");
        carStopLog.setPaymentSum(new BigDecimal(10));
        carStopService.carLeave(carStopLog);
    }

    /**
     * 缴费统计
     */
    @Test
    public void amountOfMoney() {
        BigDecimal bigDecimal = carStopService.amountOfMoney(LocalDateTime.now());
        System.out.println("统计金额：" + bigDecimal);
    }
}