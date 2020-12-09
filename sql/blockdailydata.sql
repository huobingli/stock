/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50732
Source Host           : 47.114.171.118:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-12-10 02:14:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blockdailydata
-- ----------------------------
DROP TABLE IF EXISTS `blockdailydata`;
CREATE TABLE `blockdailydata` (
  `id` int(20) NOT NULL,
  `blockcode` varchar(10) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `rise` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
