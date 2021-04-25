/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50551
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50551
 File Encoding         : 65001

 Date: 25/04/2021 11:00:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_car_stop
-- ----------------------------
DROP TABLE IF EXISTS `tb_car_stop`;
CREATE TABLE `tb_car_stop`  (
  `id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键-车牌号',
  `type` int(1) NULL DEFAULT NULL COMMENT '类型：1-货车  2-小车',
  `stop_date` datetime NULL DEFAULT NULL COMMENT '入场时间',
  `price` decimal(8, 2) NULL DEFAULT NULL COMMENT '价格/小时',
  `total` decimal(8, 2) NULL DEFAULT NULL COMMENT '最大价格/每日',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci COMMENT = '当前停车场车辆信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_car_stop
-- ----------------------------
INSERT INTO `tb_car_stop` VALUES ('川A-123431', 1, '2021-04-24 17:25:05', 10.00, 120.00);
INSERT INTO `tb_car_stop` VALUES ('川A-123433', 1, '2021-04-25 10:57:36', 10.00, 120.00);

-- ----------------------------
-- Table structure for tb_car_stop_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_car_stop_log`;
CREATE TABLE `tb_car_stop_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `car_id` varchar(16) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '车牌号',
  `type` int(1) NULL DEFAULT NULL COMMENT '类型：1-货车  2-小车',
  `stop_date` datetime NULL DEFAULT NULL COMMENT '入场时间',
  `leave_date` datetime NULL DEFAULT NULL COMMENT '离场时间',
  `price` decimal(8, 2) NULL DEFAULT NULL COMMENT '价格/小时',
  `total` decimal(8, 2) NULL DEFAULT NULL COMMENT '最大价格/每日',
  `payment_sum` decimal(8, 0) NULL DEFAULT NULL COMMENT '缴费金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = gbk COLLATE = gbk_chinese_ci COMMENT = '当前停车场车辆信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_car_stop_log
-- ----------------------------
INSERT INTO `tb_car_stop_log` VALUES (1, '川A-123432', 1, '2021-04-25 10:27:15', '2021-04-25 10:40:08', 10.00, 120.00, 10);

-- ----------------------------
-- Table structure for tb_parking_statistics
-- ----------------------------
DROP TABLE IF EXISTS `tb_parking_statistics`;
CREATE TABLE `tb_parking_statistics`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(1) NULL DEFAULT NULL COMMENT '类型：1-货车  2-小车',
  `parking_sum` int(11) NULL DEFAULT NULL COMMENT '总车位数',
  `parking_usable` int(11) NULL DEFAULT 0 COMMENT '可使用车位',
  `price` decimal(8, 2) NULL DEFAULT NULL COMMENT '价格/小时',
  `total` decimal(8, 2) NULL DEFAULT NULL COMMENT '最大价格/每日',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = gbk COLLATE = gbk_chinese_ci COMMENT = '车位统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_parking_statistics
-- ----------------------------
INSERT INTO `tb_parking_statistics` VALUES (1, 1, 60, 58, 10.00, 120.00);
INSERT INTO `tb_parking_statistics` VALUES (2, 2, 70, 70, 5.00, 60.00);

SET FOREIGN_KEY_CHECKS = 1;
