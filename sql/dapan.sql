/*
Navicat MySQL Data Transfer

Source Server         : mi
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-10-04 19:20:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dapan
-- ----------------------------
DROP TABLE IF EXISTS `dapan`;
CREATE TABLE `dapan` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `time` varchar(20) DEFAULT NULL,
  `date` varchar(20) DEFAULT '',
  `zt_num` int(8) DEFAULT NULL,
  `zf_zero_num` int(8) DEFAULT NULL,
  `dt_num` int(8) DEFAULT NULL,
  `df_zero_num` int(8) DEFAULT NULL,
  `zrztbx` double(8,2) DEFAULT NULL,
  `szzs` double(8,2) DEFAULT NULL,
  `zf_five_num` int(8) DEFAULT NULL,
  `df_five_num` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=600 DEFAULT CHARSET=utf8;
