package com.example.parking.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 车位统计表
 * </p>
 *
 * @author xy
 * @since 2021-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_parking_statistics")
public class ParkingStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型：1-货车  2-小车
     */
    @TableField("type")
    private Integer type;

    /**
     * 总车位数
     */
    @TableField("parking_sum")
    private Integer parkingSum;

    /**
     * 可使用车位
     */
    @TableField("parking_usable")
    private Integer parkingUsable;

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
