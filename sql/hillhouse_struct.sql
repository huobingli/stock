/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-09-18 23:39:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hillhouse
-- ----------------------------
DROP TABLE IF EXISTS `hillhouse`;
CREATE TABLE `hillhouse` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `stock` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `amount` int(20) DEFAULT NULL,
  `buycount` int(4) DEFAULT NULL,
  `buyway` varchar(20) DEFAULT NULL,
  `buyprice` varchar(20) DEFAULT NULL,
  `buyallmoney` varchar(20) DEFAULT NULL,
  `rate` varchar(8) DEFAULT '',
  `racetrack` varchar(20) DEFAULT NULL,
  `industry` varchar(20) DEFAULT NULL,
  `remarks` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
