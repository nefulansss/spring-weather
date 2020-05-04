/*
 Navicat Premium Data Transfer

 Source Server         : 2020aliyun
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 101.132.158.185:3306
 Source Schema         : spring-weather

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 21/03/2020 14:34:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for w_city
-- ----------------------------
DROP TABLE IF EXISTS `w_city`;
CREATE TABLE `w_city`  (
  `city_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '城市id',
  `city_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '城市名',
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of w_city
-- ----------------------------
INSERT INTO `w_city` VALUES (1, '哈尔滨市');

-- ----------------------------
-- Table structure for w_user
-- ----------------------------
DROP TABLE IF EXISTS `w_user`;
CREATE TABLE `w_user`  (
  `user_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of w_user
-- ----------------------------
INSERT INTO `w_user` VALUES (1, 'root', 'root');

-- ----------------------------
-- Table structure for w_weather
-- ----------------------------
DROP TABLE IF EXISTS `w_weather`;
CREATE TABLE `w_weather`  (
  `weather_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '天气id',
  `city_id` bigint(20) NULL DEFAULT NULL COMMENT '城市主键',
  `weather_time` timestamp(0) NULL DEFAULT NULL COMMENT '天气的时间',
  `weather_1` decimal(10, 8) NULL DEFAULT NULL COMMENT '天气1的概率',
  `weather_2` decimal(10, 8) NULL DEFAULT NULL COMMENT '天气2的概率',
  `weather_3` decimal(10, 8) NULL DEFAULT NULL COMMENT '天气3的概率',
  `weather_4` decimal(10, 8) NULL DEFAULT NULL COMMENT '天气4的概率',
  `weather_5` decimal(10, 8) NULL DEFAULT NULL COMMENT '天气5的概率',
  `weather_6` decimal(10, 8) NULL DEFAULT NULL COMMENT '天气6的概率',
  `weather_7` decimal(10, 8) NULL DEFAULT NULL COMMENT '天气7的概率',
  `weather_8` decimal(10, 8) NULL DEFAULT NULL COMMENT '天气8的概率',
  PRIMARY KEY (`weather_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of w_weather
-- ----------------------------
INSERT INTO `w_weather` VALUES (1, 1, '2020-03-21 14:26:07', 0.10000000, 0.10000000, 0.10000000, 0.15000000, 0.30000000, 0.05000000, 0.05000000, 0.20000000);
INSERT INTO `w_weather` VALUES (2, 1, '2020-03-21 14:26:07', 0.10000000, 0.10000000, 0.10000000, 0.15000000, 0.30000000, 0.05000000, 0.05000000, 0.20000000);
INSERT INTO `w_weather` VALUES (3, 1, '2020-03-21 14:26:07', 0.10000000, 0.10000000, 0.10000000, 0.15000000, 0.30000000, 0.05000000, 0.05000000, 0.20000000);

SET FOREIGN_KEY_CHECKS = 1;
