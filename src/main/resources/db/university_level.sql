/*
Navicat MySQL Data Transfer

Source Server         : 173.168.0.96
Source Server Version : 50718
Source Host           : 173.168.0.96:3306
Source Database       : simup

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-04-12 11:18:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for university_level
-- ----------------------------
DROP TABLE IF EXISTS `university_level`;
CREATE TABLE `university_level` (
  `university_level_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `university_category` smallint(6) NOT NULL,
  `university_level` smallint(6) NOT NULL,
  `university_code` varchar(5) NOT NULL,
  `undergraduate_number` smallint(6) NOT NULL DEFAULT '0',
  `graduate_number` smallint(6) NOT NULL DEFAULT '0',
  `delete_flag` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`university_level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of university_level
-- ----------------------------
INSERT INTO `university_level` VALUES ('1', '1', '1', '10001', '20', '0', '0');
INSERT INTO `university_level` VALUES ('2', '1', '2', '10246', '20', '0', '0');
INSERT INTO `university_level` VALUES ('3', '1', '2', '10002', '40', '0', '0');
INSERT INTO `university_level` VALUES ('4', '1', '3', '10034', '40', '0', '0');
INSERT INTO `university_level` VALUES ('5', '1', '3', '10384', '40', '0', '0');
INSERT INTO `university_level` VALUES ('6', '1', '3', '10272', '40', '0', '0');
INSERT INTO `university_level` VALUES ('7', '1', '3', '10036', '40', '0', '0');
INSERT INTO `university_level` VALUES ('8', '1', '4', '10053', '40', '0', '0');
INSERT INTO `university_level` VALUES ('9', '1', '4', '10422', '40', '0', '0');
INSERT INTO `university_level` VALUES ('10', '1', '4', '10532', '40', '0', '0');
INSERT INTO `university_level` VALUES ('11', '1', '4', '10651', '40', '0', '0');
INSERT INTO `university_level` VALUES ('12', '1', '4', '10520', '40', '0', '0');
INSERT INTO `university_level` VALUES ('13', '1', '4', '10033', '40', '0', '0');
INSERT INTO `university_level` VALUES ('14', '1', '5', '10173', '60', '0', '0');
INSERT INTO `university_level` VALUES ('15', '1', '5', '10038', '60', '0', '0');
INSERT INTO `university_level` VALUES ('16', '1', '5', '10070', '60', '0', '0');
INSERT INTO `university_level` VALUES ('17', '1', '5', '10276', '60', '0', '0');
INSERT INTO `university_level` VALUES ('18', '1', '5', '10273', '60', '0', '0');
INSERT INTO `university_level` VALUES ('19', '1', '5', '10327', '60', '0', '0');
INSERT INTO `university_level` VALUES ('20', '1', '6', '10697', '60', '0', '0');
INSERT INTO `university_level` VALUES ('21', '1', '6', '10011', '60', '0', '0');
INSERT INTO `university_level` VALUES ('22', '1', '6', '10652', '60', '0', '0');
INSERT INTO `university_level` VALUES ('23', '1', '6', '10353', '60', '0', '0');
INSERT INTO `university_level` VALUES ('24', '1', '6', '10421', '60', '0', '0');
INSERT INTO `university_level` VALUES ('25', '1', '6', '10673', '60', '0', '0');
INSERT INTO `university_level` VALUES ('26', '1', '6', '10357', '60', '0', '0');
INSERT INTO `university_level` VALUES ('27', '1', '6', '10140', '60', '0', '0');
INSERT INTO `university_level` VALUES ('28', '2', '1', '10001', '20', '0', '0');
INSERT INTO `university_level` VALUES ('29', '2', '2', '10246', '20', '0', '0');
INSERT INTO `university_level` VALUES ('30', '2', '2', '10284', '40', '0', '0');
INSERT INTO `university_level` VALUES ('31', '2', '3', '10055', '40', '0', '0');
INSERT INTO `university_level` VALUES ('32', '2', '3', '10027', '40', '0', '0');
INSERT INTO `university_level` VALUES ('33', '2', '3', '10558', '40', '0', '0');
INSERT INTO `university_level` VALUES ('34', '2', '3', '10486', '40', '0', '0');
INSERT INTO `university_level` VALUES ('35', '2', '4', '10269', '40', '0', '0');
INSERT INTO `university_level` VALUES ('36', '2', '4', '10533', '40', '0', '0');
INSERT INTO `university_level` VALUES ('37', '2', '4', '10610', '40', '0', '0');
INSERT INTO `university_level` VALUES ('38', '2', '4', '10183', '40', '0', '0');
INSERT INTO `university_level` VALUES ('39', '2', '4', '10611', '40', '0', '0');
INSERT INTO `university_level` VALUES ('40', '2', '4', '10423', '40', '0', '0');
INSERT INTO `university_level` VALUES ('41', '2', '5', '10559', '60', '0', '0');
INSERT INTO `university_level` VALUES ('42', '2', '5', '10730', '60', '0', '0');
INSERT INTO `university_level` VALUES ('43', '2', '5', '10280', '60', '0', '0');
INSERT INTO `university_level` VALUES ('44', '2', '5', '10285', '60', '0', '0');
INSERT INTO `university_level` VALUES ('45', '2', '5', '10511', '60', '0', '0');
INSERT INTO `university_level` VALUES ('46', '2', '5', '10590', '60', '0', '0');
INSERT INTO `university_level` VALUES ('47', '2', '6', '10459', '60', '0', '0');
INSERT INTO `university_level` VALUES ('48', '2', '6', '10319', '60', '0', '0');
INSERT INTO `university_level` VALUES ('49', '2', '6', '10028', '60', '0', '0');
INSERT INTO `university_level` VALUES ('50', '2', '6', '10200', '60', '0', '0');
INSERT INTO `university_level` VALUES ('51', '2', '6', '10635', '60', '0', '0');
INSERT INTO `university_level` VALUES ('52', '2', '6', '10574', '60', '0', '0');
INSERT INTO `university_level` VALUES ('53', '2', '6', '10560', '60', '0', '0');
INSERT INTO `university_level` VALUES ('54', '2', '6', '10542', '60', '0', '0');
INSERT INTO `university_level` VALUES ('55', '3', '1', '10003', '20', '0', '0');
INSERT INTO `university_level` VALUES ('56', '3', '2', '10248', '20', '0', '0');
INSERT INTO `university_level` VALUES ('57', '3', '2', '10358', '40', '0', '0');
INSERT INTO `university_level` VALUES ('58', '3', '3', '10006', '40', '0', '0');
INSERT INTO `university_level` VALUES ('59', '3', '3', '10698', '40', '0', '0');
INSERT INTO `university_level` VALUES ('60', '3', '3', '10487', '40', '0', '0');
INSERT INTO `university_level` VALUES ('61', '3', '3', '10007', '40', '0', '0');
INSERT INTO `university_level` VALUES ('62', '3', '4', '10013', '40', '0', '0');
INSERT INTO `university_level` VALUES ('63', '3', '4', '10699', '40', '0', '0');
INSERT INTO `university_level` VALUES ('64', '3', '4', '10614', '40', '0', '0');
INSERT INTO `university_level` VALUES ('65', '3', '4', '10004', '40', '0', '0');
INSERT INTO `university_level` VALUES ('66', '3', '4', '10287', '40', '0', '0');
INSERT INTO `university_level` VALUES ('67', '3', '4', '10701', '40', '0', '0');
INSERT INTO `university_level` VALUES ('68', '3', '5', '10145', '60', '0', '0');
INSERT INTO `university_level` VALUES ('69', '3', '5', '10005', '60', '0', '0');
INSERT INTO `university_level` VALUES ('70', '3', '5', '10613', '60', '0', '0');
INSERT INTO `university_level` VALUES ('71', '3', '5', '10497', '60', '0', '0');
INSERT INTO `university_level` VALUES ('72', '3', '5', '10255', '60', '0', '0');
INSERT INTO `university_level` VALUES ('73', '3', '5', '10295', '60', '0', '0');
INSERT INTO `university_level` VALUES ('74', '3', '6', '10359', '60', '0', '0');
INSERT INTO `university_level` VALUES ('75', '3', '6', '10710', '60', '0', '0');
INSERT INTO `university_level` VALUES ('76', '3', '6', '10293', '60', '0', '0');
INSERT INTO `university_level` VALUES ('77', '3', '6', '10252', '60', '0', '0');
INSERT INTO `university_level` VALUES ('78', '3', '6', '10216', '60', '0', '0');
INSERT INTO `university_level` VALUES ('79', '3', '6', '10299', '60', '0', '0');
INSERT INTO `university_level` VALUES ('80', '3', '6', '10403', '60', '0', '0');
INSERT INTO `university_level` VALUES ('81', '3', '6', '10112', '60', '0', '0');
INSERT INTO `university_level` VALUES ('82', '4', '1', '10003', '20', '0', '0');
INSERT INTO `university_level` VALUES ('83', '4', '2', '10248', '20', '0', '0');
INSERT INTO `university_level` VALUES ('84', '4', '2', '10335', '40', '0', '0');
INSERT INTO `university_level` VALUES ('85', '4', '3', '10247', '40', '0', '0');
INSERT INTO `university_level` VALUES ('86', '4', '3', '10213', '40', '0', '0');
INSERT INTO `university_level` VALUES ('87', '4', '3', '10056', '40', '0', '0');
INSERT INTO `university_level` VALUES ('88', '4', '3', '10286', '40', '0', '0');
INSERT INTO `university_level` VALUES ('89', '4', '4', '10141', '40', '0', '0');
INSERT INTO `university_level` VALUES ('90', '4', '4', '10561', '40', '0', '0');
INSERT INTO `university_level` VALUES ('91', '4', '4', '10008', '40', '0', '0');
INSERT INTO `university_level` VALUES ('92', '4', '4', '10079', '40', '0', '0');
INSERT INTO `university_level` VALUES ('93', '4', '4', '10251', '40', '0', '0');
INSERT INTO `university_level` VALUES ('94', '4', '4', '10288', '40', '0', '0');
INSERT INTO `university_level` VALUES ('95', '4', '5', '10010', '60', '0', '0');
INSERT INTO `university_level` VALUES ('96', '4', '5', '10217', '60', '0', '0');
INSERT INTO `university_level` VALUES ('97', '4', '5', '10294', '60', '0', '0');
INSERT INTO `university_level` VALUES ('98', '4', '5', '10491', '60', '0', '0');
INSERT INTO `university_level` VALUES ('99', '4', '5', '11414', '60', '0', '0');
INSERT INTO `university_level` VALUES ('100', '4', '5', '10151', '60', '0', '0');
INSERT INTO `university_level` VALUES ('101', '4', '6', '10080', '60', '0', '0');
INSERT INTO `university_level` VALUES ('102', '4', '6', '10386', '60', '0', '0');
INSERT INTO `university_level` VALUES ('103', '4', '6', '10290', '60', '0', '0');
INSERT INTO `university_level` VALUES ('104', '4', '6', '10337', '60', '0', '0');
INSERT INTO `university_level` VALUES ('105', '4', '6', '10254', '60', '0', '0');
INSERT INTO `university_level` VALUES ('106', '4', '6', '10016', '60', '0', '0');
INSERT INTO `university_level` VALUES ('107', '4', '6', '10703', '60', '0', '0');
INSERT INTO `university_level` VALUES ('108', '4', '6', '10291', '60', '0', '0');
