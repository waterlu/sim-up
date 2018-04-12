/*
Navicat MySQL Data Transfer

Source Server         : 173.168.0.96
Source Server Version : 50718
Source Host           : 173.168.0.96:3306
Source Database       : simup

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-04-12 11:18:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subject_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `subject_code` varchar(4) NOT NULL COMMENT '学科编码',
  `subject_name` varchar(32) NOT NULL COMMENT '学科名称',
  `subject_cn_name` varchar(16) DEFAULT NULL COMMENT '学科中文名称',
  `delete_flag` smallint(6) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `idx_subject_subject_code` (`subject_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '0201', 'Economics', '理论经济学', '0');
INSERT INTO `subject` VALUES ('2', '0202', 'Finance', '应用经济学', '0');
INSERT INTO `subject` VALUES ('3', '1202', 'Accounting', '工商管理', '0');
INSERT INTO `subject` VALUES ('4', '0301', 'Law', '法学', '0');
INSERT INTO `subject` VALUES ('5', '0502', 'Lauguage', '外国语言文学', '0');
INSERT INTO `subject` VALUES ('6', '1201', 'Management', '管理科学与工程', '0');
INSERT INTO `subject` VALUES ('7', '0503', 'Journalism', '新闻传播学', '0');
INSERT INTO `subject` VALUES ('8', '0714', 'Statistics', '统计学', '0');
INSERT INTO `subject` VALUES ('9', '0303', 'Sociology', '社会学', '0');
INSERT INTO `subject` VALUES ('10', '1204', 'Public Management', '公共管理', '0');
INSERT INTO `subject` VALUES ('11', '0701', 'Mathematics', '数学', '0');
INSERT INTO `subject` VALUES ('12', '0809', 'Electronics', '电子科学与技术', '0');
INSERT INTO `subject` VALUES ('13', '0702', 'Physics', '物理学', '0');
INSERT INTO `subject` VALUES ('14', '0703', 'Chemistry', '化学', '0');
INSERT INTO `subject` VALUES ('15', '1002', 'Medicine', '临床医学', '0');
INSERT INTO `subject` VALUES ('16', '0710', 'Biology', '生物学', '0');
INSERT INTO `subject` VALUES ('17', '0713', 'Ecology', '生态学', '0');
INSERT INTO `subject` VALUES ('18', '0812', 'Computer', '计算机科学与技术', '0');
INSERT INTO `subject` VALUES ('19', '0802', 'Mechanical Engineering', '机械工程', '0');
INSERT INTO `subject` VALUES ('20', '0805', 'Material Engineering', '材料科学与工程', '0');
INSERT INTO `subject` VALUES ('21', '0811', 'Automatization', '控制科学与工程', '0');
INSERT INTO `subject` VALUES ('22', '0810', 'Communication Engineering', '信息与通信工程', '0');
INSERT INTO `subject` VALUES ('23', '0823', 'Transportation', '交通运输工程', '0');
INSERT INTO `subject` VALUES ('24', '0830', 'Environmental Engineering', '环境科学与工程', '0');
INSERT INTO `subject` VALUES ('25', '0803', 'Optical Engineering', '光学工程', '0');
INSERT INTO `subject` VALUES ('26', '0813', 'Architecture', '建筑学', '0');
INSERT INTO `subject` VALUES ('27', '0814', 'Civil  Engineering', '土木工程', '0');
INSERT INTO `subject` VALUES ('28', '0808', 'ElectricalEngineering', '电气工程', '0');
INSERT INTO `subject` VALUES ('29', '0817', 'ChemicalEngineering', '化学工程与技术', '0');
INSERT INTO `subject` VALUES ('30', '0815', 'HydraulicEngineering', '水利工程', '0');
