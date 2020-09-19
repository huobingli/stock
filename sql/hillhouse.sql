/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-09-20 01:46:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hillhouse
-- ----------------------------
DROP TABLE IF EXISTS `hillhouse`;
CREATE TABLE `hillhouse` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT '',
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

-- ----------------------------
-- Records of hillhouse
-- ----------------------------
INSERT INTO `hillhouse` VALUES ('1', '600267', '海正药业', '2020-07-21 00:00:46', '349000000', '1', '定增', '13.15', '4400000000', '0.168', '创新药', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('2', '600380', '健康元', '2020-07-12 00:00:00', '169000000', '1', '定增', '13.83', '2170000000', '0.08', '呼吸', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('3', '603087', '甘李药业', '2020-06-29 00:00:00', '0', '1', '一级市场', '0', '0', '0.0452', '糖尿病', '生物医药', '买入估值PE的32.97倍');
INSERT INTO `hillhouse` VALUES ('4', '300285', '国瓷材料', '2020-06-18 00:00:00', '31200000', '1', '定增', '20.67', '645000000', '0.0330', '牙科', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('5', '300529', '健帆生物', '2020-06-04 00:00:00', '15860000', '1', '大宗转让', '56.30', '900000000', '0.0199', '肾科', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('6', '300326', '凯利泰', '2020-05-12 00:00:00', '21000000', '2', '定增', '18.73', '390000000', '0.0290', '骨科', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('7', '300347', '泰格医药', '2020-05-09 00:00:00', '5000000', '2', '大宗转让', '74.20', '371000000', '0.0066', 'CRO', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('8', '002821', '凯莱英', '2020-02-16 00:00:00', '1400000', '1', '二级市场', '123.56', '172000000', '0.0060', 'CRO', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('9', '603882', '金域医学', '2019-12-30 00:00:00', '5750000', '1', '二级市场', '55.00', '316000000', '0.0125', '独立医学实验室', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('10', '300326', '凯利泰', '2019-09-10 00:00:00', '17620000', '1', '二级市场', '15.00', '264000000', '0.0243', '骨科', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('11', '300347', '泰格医药', '2018-06-11 00:00:00', '7500000', '1', '大宗转让', '36.66', '275000000', '0.0100', 'CRO', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('12', '603259', '药明康德', '2018-04-23 00:00:00', '0', '1', '一级市场', '0', '0', '0.0179', 'CRO', '生物医药', '美股私有化分拆A股上市');
INSERT INTO `hillhouse` VALUES ('13', '300015', '爱尔眼科', '2018-01-05 00:00:00', '37180000', '1', '定增', '16.00', '1026000000', '0.0157', '眼科', '生物医药', null);
INSERT INTO `hillhouse` VALUES ('14', '002812', '恩捷股份', '2020-09-03 00:00:00', '69440000', '1', '定增', '72.00', '1500000000', '0.0230', '新能源', '消费', null);
INSERT INTO `hillhouse` VALUES ('15', '300750', '宁德时代', '2020-07-17 00:00:00', '65830000', '2', '定增', '161.00', '900000000', '0.0320', '新能源', '消费', null);
INSERT INTO `hillhouse` VALUES ('16', '000858', '五粮液', '2020-03-30 00:00:00', '10300000', '1', '二级市场', '130.00', '1800000000', '0.0028', '白酒', '消费', null);
INSERT INTO `hillhouse` VALUES ('17', '603719', '良品铺子', '2020-02-24 00:00:00', '0', '1', '一级市场', '0', '0', '0.1300', '零食', '消费', '买入估值是1.2PS,30PE');
INSERT INTO `hillhouse` VALUES ('18', '603195', '公牛集团', '2020-02-06 00:00:00', '0', '2', '一级市场', '0', '0', '0.0201', '电工', '消费', '买入估值是PE27.86');
INSERT INTO `hillhouse` VALUES ('19', '000651', '格力电器', '2019-12-03 00:00:00', '902000000', '2', '大宗转让', '46.17', '41600000000', '0.1500', '空调', '消费', null);
INSERT INTO `hillhouse` VALUES ('20', '600779', '水井坊', '2019-02-01 00:00:00', '4520000', '2', '二级市场', '33.00', '108000000', '0.0092', '白酒', '消费', null);
INSERT INTO `hillhouse` VALUES ('21', '300750', '宁德时代', '2018-09-30 00:00:00', '3280000', '2', '二级市场', '70.00', '278000000', '0.0150', '新能源', '消费', null);
INSERT INTO `hillhouse` VALUES ('22', '000651', '格力电器', '2016-03-30 00:00:00', '43390000', '2', '二级市场', '14.65', '635000000', '0.0072', '空调', '消费', null);
INSERT INTO `hillhouse` VALUES ('23', '002410', '广联达', '2020-06-16 00:00:00', '29710000', '2', '定增', '50.48', '1500000000', '0.0251', 'SAAS行业', '企业服务', null);
INSERT INTO `hillhouse` VALUES ('24', '600585', '海螺水泥', '2019-10-23 00:00:00', '37320000', '2', '二级市场', '40.00', '1500000000', '0.0070', '水泥', '其他', null);
