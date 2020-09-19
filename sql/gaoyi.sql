/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-09-20 01:46:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gaoyi
-- ----------------------------
DROP TABLE IF EXISTS `gaoyi`;
CREATE TABLE `gaoyi` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT '',
  `name` varchar(20) DEFAULT '',
  `time` datetime DEFAULT NULL,
  `amount` int(20) DEFAULT NULL,
  `buycount` int(4) DEFAULT NULL,
  `buyway` varchar(20) DEFAULT '',
  `buyprice` varchar(20) DEFAULT '',
  `buyallmoney` varchar(20) DEFAULT '',
  `rate` varchar(8) DEFAULT '',
  `racetrack` varchar(20) DEFAULT '',
  `industry` varchar(20) DEFAULT '',
  `remarks` varchar(30) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gaoyi
-- ----------------------------
INSERT INTO `gaoyi` VALUES ('1', '002602', '世纪华通', '2020-08-29 00:00:00', '3000000', null, '增加', null, null, '0.0482', '游戏', null, null);
INSERT INTO `gaoyi` VALUES ('2', '000100', 'TCL科技', '2020-08-29 00:00:00', '100000000', null, '新进', null, null, '0.0079', '消费电子', null, null);
INSERT INTO `gaoyi` VALUES ('3', '600007', '中国国贸', '2020-08-29 00:00:00', '7500000', null, '新进', null, null, '0.0074', '房产', null, null);
INSERT INTO `gaoyi` VALUES ('5', '000998', '隆平高科', '2020-08-29 00:00:00', '56000000', null, '不变', null, null, '0.0578', '农产品加工', null, null);
INSERT INTO `gaoyi` VALUES ('6', '002624', '完美世界', '2020-08-29 00:00:00', '57000000', null, '增加', null, null, '0.0478', '游戏', null, null);
INSERT INTO `gaoyi` VALUES ('7', '603197', '保隆科技', '2020-08-29 00:00:00', '5000000', null, '减少', null, null, '0.0305', '汽车零部件', null, null);
INSERT INTO `gaoyi` VALUES ('8', '600699', '均胜电子', '2020-08-29 00:00:00', '20000000', null, '新进', null, null, '0.0162', '汽车零部件', null, null);
INSERT INTO `gaoyi` VALUES ('9', '000028', '国药一致', '2020-08-29 00:00:00', '10000000', null, '新进', null, null, '0.0272', '医药商业', null, null);
INSERT INTO `gaoyi` VALUES ('10', '600297', '广汇汽车', '2020-08-29 00:00:00', '170000000', null, '不变', null, null, '0.0210', '汽车零售', null, null);
INSERT INTO `gaoyi` VALUES ('11', '002171', '楚江新材', '2020-08-28 00:00:00', '16150000', null, '减少', null, null, '0.0134', null, null, null);
INSERT INTO `gaoyi` VALUES ('12', '300428', '四通新材', '2020-08-28 00:00:00', '10910000', null, '新进', null, null, '0.0592', '多种金属与采矿', null, null);
INSERT INTO `gaoyi` VALUES ('13', '300203', '聚光科技', '2020-08-28 00:00:00', '7500000', null, '新进', null, null, '0.0166', '环保工程及服务', null, null);
INSERT INTO `gaoyi` VALUES ('14', '300188', '美亚柏科', '2020-08-28 00:00:00', '30000000', null, '新进', null, null, '0.0500', '信息科技咨询与其他服务', null, null);
INSERT INTO `gaoyi` VALUES ('15', '000681', '视觉中国', '2020-08-28 00:00:00', '15000000', null, '新进', null, null, '0.0226', '信息科技咨询与其他服务', null, null);
INSERT INTO `gaoyi` VALUES ('16', '300408', '三环集团', '2020-08-28 00:00:00', '30000000', null, '新进', null, null, '0.0181', '电子元件', null, null);
INSERT INTO `gaoyi` VALUES ('17', '300078', '思创医惠', '2020-08-28 00:00:00', '13130000', null, '新进', null, null, '0.0168', '电子设备制造', null, null);
INSERT INTO `gaoyi` VALUES ('18', '603599', '广信股份', '2020-08-28 00:00:00', '15000000', null, '增加', null, null, '0.0323', '化肥与农用药剂', null, null);
INSERT INTO `gaoyi` VALUES ('19', '300777', '中简科技', '2020-08-28 00:00:00', '7900000', null, '新进', null, null, '0.0301', '其他纤维', null, null);
INSERT INTO `gaoyi` VALUES ('20', '002287', '奇正藏药', '2020-08-28 00:00:00', '1000000', null, '减少', null, null, '0.0019', null, null, null);
INSERT INTO `gaoyi` VALUES ('21', '600461', '洪城水业', '2020-08-27 00:00:00', '20000000', null, '不变', null, null, '0.0253', '公用事业', null, null);
INSERT INTO `gaoyi` VALUES ('22', '002153', '石基信息', '2020-08-27 00:00:00', '10000000', null, '新进', null, null, '0.0205', '软件和信息技术服务业', null, null);
INSERT INTO `gaoyi` VALUES ('23', '300294', '博雅生物', '2020-08-27 00:00:00', '11000000', null, '增加', null, null, '0.0254', '生物医药', null, null);
INSERT INTO `gaoyi` VALUES ('24', '002055', '得润电子', '2020-08-27 00:00:00', '7340000', null, '新进', null, null, '0.0171', '电子零部件制造', null, null);
INSERT INTO `gaoyi` VALUES ('25', '300603', '立昂技术', '2020-08-27 00:00:00', '6520000', null, '新进', null, null, '0.0429', '软件和信息技术服务业', null, null);
INSERT INTO `gaoyi` VALUES ('26', '600315', '上海家化', '2020-08-27 00:00:00', '13000000', null, '新进', null, null, '0.0194', '日用化学品', null, null);
INSERT INTO `gaoyi` VALUES ('27', '300674', '宇信科技', '2020-08-27 00:00:00', '7800000', null, '新进', null, null, '0.0283', '软件和信息技术服务业', null, null);
INSERT INTO `gaoyi` VALUES ('28', '300063', '天龙集团', '2020-08-27 00:00:00', '11130000', null, '新进', null, null, '0.0186', '商务服务业', null, null);
INSERT INTO `gaoyi` VALUES ('29', '002851', '麦格米特', '2020-08-27 00:00:00', '18500000', null, '新进', null, null, '0.0558', '电气部件与设备', null, null);
INSERT INTO `gaoyi` VALUES ('30', '002013', '中航机电', '2020-08-26 00:00:00', '138000000', null, '增加', null, null, '0.0382', '航天航空与国防', null, null);
INSERT INTO `gaoyi` VALUES ('31', '002352', '顺丰控股', '0000-00-00 00:00:00', '23000000', null, '不变', null, null, '0.0052', '邮政业', null, null);
INSERT INTO `gaoyi` VALUES ('32', '002174', '游族网络', '2020-08-26 00:00:00', '5000000', null, '新进', null, null, '0.0074', '游戏', null, null);
INSERT INTO `gaoyi` VALUES ('33', '002382', '蓝帆医疗', '2020-08-26 00:00:00', '46000000', null, '不变', null, null, '0.0718', '医疗保健设备', null, null);
INSERT INTO `gaoyi` VALUES ('34', '300662', '科锐国际', '2020-08-26 00:00:00', '3650000', null, '新进', null, null, '0.0203', '人力资源与就业服务', null, null);
INSERT INTO `gaoyi` VALUES ('35', '002773', '康弘药业', '2020-08-26 00:00:00', '10000000', null, '新进', null, null, '0.0161', '医药制造业', null, null);
INSERT INTO `gaoyi` VALUES ('36', '002864', '盘龙药业', '2020-08-25 00:00:00', '1080000', null, '减少', null, null, '0.0235', null, null, null);
INSERT INTO `gaoyi` VALUES ('37', '000938', '紫光股份', '2020-08-25 00:00:00', '45000000', null, '减少', null, null, '0.0220', null, null, null);
INSERT INTO `gaoyi` VALUES ('38', '002524', '光正集团', '2020-08-25 00:00:00', '13000000', null, '新进', null, null, '0.0268', '保健护理机构', null, null);
INSERT INTO `gaoyi` VALUES ('39', '300418', '昆仑万维', '2020-08-25 00:00:00', '35000000', null, '新进', null, null, '0.0349', '游戏', null, null);
INSERT INTO `gaoyi` VALUES ('40', '300770', '新媒股份', '2020-08-25 00:00:00', '3840000', null, '新进', null, null, '0.0488', '电信、广播电视和卫星传输', null, null);
INSERT INTO `gaoyi` VALUES ('41', '600079', '人福医药', '2020-08-22 00:00:00', '63800000', null, '减少', null, null, '0.0496', null, null, null);
INSERT INTO `gaoyi` VALUES ('42', '603766', '隆鑫通用', '2020-08-22 00:00:00', '70000000', null, '减少', null, null, '0.0341', '摩托车制造商', null, null);
INSERT INTO `gaoyi` VALUES ('43', '000921', '海信家电', '2020-08-21 00:00:00', '51800000', null, '新进', null, null, '0.0574', '白色家电', null, null);
INSERT INTO `gaoyi` VALUES ('44', '002236', '大华股份', '2020-08-21 00:00:00', '85000000', null, '新进', null, null, '0.0458', 'PC、服务器及硬件', null, null);
INSERT INTO `gaoyi` VALUES ('45', '002084', '海鸥住工', '2020-08-21 00:00:00', '7500000', null, '新进', null, null, '0.0139', '家用器具', null, null);
INSERT INTO `gaoyi` VALUES ('46', '603058', '永吉股份', '2020-08-21 00:00:00', '6610000', null, '新进', null, null, '0.0294', '商业印刷', null, null);
INSERT INTO `gaoyi` VALUES ('47', '600557', '康缘药业', '2020-08-20 00:00:00', '11500000', null, '新进', null, null, '0.0194', '中药生产', null, null);
INSERT INTO `gaoyi` VALUES ('48', '601615', '明阳智能', '2020-08-20 00:00:00', '10000000', null, '增加', null, null, '0.0108', '风电设备', null, null);
INSERT INTO `gaoyi` VALUES ('49', '600285', '羚锐制药', '2020-08-18 00:00:00', '27000000', null, '增加', null, null, '0.0571', '中药生产', null, null);
INSERT INTO `gaoyi` VALUES ('50', '600057', '厦门象屿', '2020-08-06 00:00:00', '30000000', null, '不变', null, null, '0.0139', '物流', null, null);
INSERT INTO `gaoyi` VALUES ('51', '002258', '利尔化学', '2020-08-06 00:00:00', '10000000', null, '减少', null, null, '0.0192', null, null, null);
INSERT INTO `gaoyi` VALUES ('52', '002456', '欧菲光', '2020-08-04 00:00:00', '17800000', null, '新进', null, null, '0.0067', '消费电子', null, null);
INSERT INTO `gaoyi` VALUES ('53', '002601', '龙蟒佰利', '2020-08-01 00:00:00', '30000000', null, '新进', null, null, '0.0212', '其他化学制品', null, null);
INSERT INTO `gaoyi` VALUES ('54', '688018', '乐鑫科技', '2020-07-31 00:00:00', '350000', null, '新进', null, null, '0.0191', '软件和信息技术服务业', null, null);
INSERT INTO `gaoyi` VALUES ('55', '603650', '彤程新材', '2020-08-15 00:00:00', '7500000', null, '新进', null, null, '0.0476', '化学原料及化学制品制造业', null, null);
