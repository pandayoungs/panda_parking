package com.example.parking.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 当前停车场车辆信息
 * </p>
 *
 * @author xy
 * @since 2021-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_car_stop")
@Accessors(chain = true)
public class CarStop implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键-车牌号
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 类型：1-货车  2-小车
     */
    @TableField("type")
    private Integer type;

    /**
     * 入场时间
     */
    @TableField("stop_date")
    private LocalDateTime stopDate;

    /**
     * 价格/小时
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 最大价格/每日
     */
    @TableField("total")
    private BigDecimal total;


}
