/*
Navicat MySQL Data Transfer

Source Server         : mi
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-09-23 20:18:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dapan
-- ----------------------------
DROP TABLE IF EXISTS `dapan`;
CREATE TABLE `dapan` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `time` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `limitupcount` int(8) DEFAULT NULL,
  `risecount` int(8) DEFAULT NULL,
  `limitdowncount` int(8) DEFAULT NULL,
  `fallcount` int(8) DEFAULT NULL,
  `prelimitup` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8;
