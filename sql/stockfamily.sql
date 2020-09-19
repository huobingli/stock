/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-09-20 01:46:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stockfamily
-- ----------------------------
DROP TABLE IF EXISTS `stockfamily`;
CREATE TABLE `stockfamily` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `code` varchar(20) DEFAULT '',
  `name` varchar(20) DEFAULT NULL,
  `buyprice` varchar(20) DEFAULT NULL,
  `sellprice` varchar(20) DEFAULT NULL,
  `gainpercent` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stockfamily
-- ----------------------------
