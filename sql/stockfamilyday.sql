/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-09-20 01:47:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stockfamilyday
-- ----------------------------
DROP TABLE IF EXISTS `stockfamilyday`;
CREATE TABLE `stockfamilyday` (
  `id` int(8) NOT NULL,
  `date` datetime DEFAULT NULL,
  `gains` varchar(20) DEFAULT NULL,
  `percent` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stockfamilyday
-- ----------------------------
