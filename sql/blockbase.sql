/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50732
Source Host           : 47.114.171.118:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-12-10 02:52:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blockbase
-- ----------------------------
DROP TABLE IF EXISTS `blockbase`;
CREATE TABLE `blockbase` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `blockcode` int(10) DEFAULT NULL,
  `blockname` varchar(20) DEFAULT NULL,
  `blocktype` int(4) NOT NULL,
  `blockfstname` varchar(20) DEFAULT NULL,
  `blockcount` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
