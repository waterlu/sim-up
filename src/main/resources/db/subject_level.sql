/*
Navicat MySQL Data Transfer

Source Server         : 173.168.0.96
Source Server Version : 50718
Source Host           : 173.168.0.96:3306
Source Database       : simup

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-04-12 11:18:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for subject_level
-- ----------------------------
DROP TABLE IF EXISTS `subject_level`;
CREATE TABLE `subject_level` (
  `subject_level_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `subject_category` smallint(6) NOT NULL,
  `subject_level` smallint(6) NOT NULL,
  `subject_code` varchar(4) NOT NULL,
  `delete_flag` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`subject_level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject_level
-- ----------------------------
INSERT INTO `subject_level` VALUES ('1', '1', '1', '0201', '0');
INSERT INTO `subject_level` VALUES ('2', '1', '1', '0202', '0');
INSERT INTO `subject_level` VALUES ('3', '1', '1', '1202', '0');
INSERT INTO `subject_level` VALUES ('4', '1', '2', '0301', '0');
INSERT INTO `subject_level` VALUES ('5', '1', '2', '0502', '0');
INSERT INTO `subject_level` VALUES ('6', '1', '2', '0503', '0');
INSERT INTO `subject_level` VALUES ('7', '1', '2', '0714', '0');
INSERT INTO `subject_level` VALUES ('8', '1', '2', '1201', '0');
INSERT INTO `subject_level` VALUES ('9', '1', '3', '0303', '0');
INSERT INTO `subject_level` VALUES ('10', '1', '3', '1204', '0');
INSERT INTO `subject_level` VALUES ('11', '2', '1', '0201', '0');
INSERT INTO `subject_level` VALUES ('12', '2', '1', '0701', '0');
INSERT INTO `subject_level` VALUES ('13', '2', '1', '0809', '0');
INSERT INTO `subject_level` VALUES ('14', '2', '2', '0301', '0');
INSERT INTO `subject_level` VALUES ('15', '2', '2', '0502', '0');
INSERT INTO `subject_level` VALUES ('16', '2', '2', '0702', '0');
INSERT INTO `subject_level` VALUES ('17', '2', '2', '0703', '0');
INSERT INTO `subject_level` VALUES ('18', '2', '2', '1002', '0');
INSERT INTO `subject_level` VALUES ('19', '2', '3', '0710', '0');
INSERT INTO `subject_level` VALUES ('20', '2', '3', '0713', '0');
INSERT INTO `subject_level` VALUES ('21', '3', '1', '0701', '0');
INSERT INTO `subject_level` VALUES ('22', '3', '1', '0809', '0');
INSERT INTO `subject_level` VALUES ('23', '3', '1', '0812', '0');
INSERT INTO `subject_level` VALUES ('24', '3', '2', '0802', '0');
INSERT INTO `subject_level` VALUES ('25', '3', '2', '0805', '0');
INSERT INTO `subject_level` VALUES ('26', '3', '2', '0811', '0');
INSERT INTO `subject_level` VALUES ('27', '3', '2', '0810', '0');
INSERT INTO `subject_level` VALUES ('28', '3', '2', '0823', '0');
INSERT INTO `subject_level` VALUES ('29', '3', '3', '0830', '0');
INSERT INTO `subject_level` VALUES ('30', '3', '3', '0803', '0');
INSERT INTO `subject_level` VALUES ('31', '4', '1', '0812', '0');
INSERT INTO `subject_level` VALUES ('32', '4', '1', '1202', '0');
INSERT INTO `subject_level` VALUES ('33', '4', '1', '0813', '0');
INSERT INTO `subject_level` VALUES ('34', '4', '2', '0802', '0');
INSERT INTO `subject_level` VALUES ('35', '4', '2', '0805', '0');
INSERT INTO `subject_level` VALUES ('36', '4', '2', '1201', '0');
INSERT INTO `subject_level` VALUES ('37', '4', '2', '0814', '0');
INSERT INTO `subject_level` VALUES ('38', '4', '2', '0808', '0');
INSERT INTO `subject_level` VALUES ('39', '4', '3', '0817', '0');
INSERT INTO `subject_level` VALUES ('40', '4', '3', '0815', '0');
