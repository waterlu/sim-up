/*
Navicat MySQL Data Transfer

Source Server         : 173.168.0.96
Source Server Version : 50718
Source Host           : 173.168.0.96:3306
Source Database       : simup

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-04-12 11:18:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for university
-- ----------------------------
DROP TABLE IF EXISTS `university`;
CREATE TABLE `university` (
  `university_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `university_code` varchar(5) NOT NULL,
  `university_name` varchar(64) NOT NULL,
  `university_cn_name` varchar(32) DEFAULT NULL,
  `university_name_abbr` varchar(8) DEFAULT NULL,
  `university_type` varchar(4) DEFAULT NULL,
  `rank_2005_2015` smallint(6) DEFAULT NULL,
  `rank_me` smallint(6) DEFAULT NULL,
  `rank_2017` smallint(6) DEFAULT NULL,
  `university_location` tinyint(4) DEFAULT NULL,
  `delete_flag` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`university_id`),
  UNIQUE KEY `idx_university_university_code` (`university_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of university
-- ----------------------------
INSERT INTO `university` VALUES ('1', '10003', 'Tsinghua University', '清华大学', 'TSINGHUA', '综合', '1', '1', '1', '11', '0');
INSERT INTO `university` VALUES ('2', '10001', 'Peking University', '北京大学', 'PKU', '综合', '2', '2', '2', '11', '0');
INSERT INTO `university` VALUES ('3', '10246', 'Fudan University', '复旦大学', 'FUDAN', '综合', '3', '3', '4', '31', '0');
INSERT INTO `university` VALUES ('4', '10248', 'Shanghai Jiao Tong University', '上海交通大学', 'SJTU', '综合', '4', '4', '3', '31', '0');
INSERT INTO `university` VALUES ('5', '10358', 'University of Science and Technology of China', '中国科学技术大学', 'USTC', '工科', '5', '7', '8', '34', '0');
INSERT INTO `university` VALUES ('6', '10002', 'Renmin University of China', '中国人民大学', 'RUC', '综合', '6', '5', '7', '11', '0');
INSERT INTO `university` VALUES ('7', '10335', 'Zhejiang University', '浙江大学', 'ZJU', '综合', '7', '6', '5', '33', '0');
INSERT INTO `university` VALUES ('8', '10284', 'Nanjing University', '南京大学', 'NJU', '综合', '8', '8', '10', '32', '0');
INSERT INTO `university` VALUES ('9', '10006', 'Beihang University', '北京航空航天大学', 'BUAA', '工科', '9', '9', '14', '11', '0');
INSERT INTO `university` VALUES ('10', '10247', 'Tongji University', '同济大学', 'TONGJI', '工科', '10', '10', '11', '31', '0');
INSERT INTO `university` VALUES ('11', '10055', 'Nankai University', '南开大学', 'NKU', '综合', '12', '13', '16', '12', '0');
INSERT INTO `university` VALUES ('12', '10698', 'Xian Jiaotong University', '西安交通大学', 'XJTU', '综合', '17', '15', '19', '61', '0');
INSERT INTO `university` VALUES ('13', '10213', 'Harbin Institute of Technology', '哈尔滨工业大学', 'HIT', '工科', '29', '20', '23', '23', '0');
INSERT INTO `university` VALUES ('14', '10027', 'Beijing Normal University', '北京师范大学', 'BNU', '师范', '16', '21', '34', '11', '0');
INSERT INTO `university` VALUES ('15', '10558', 'Sun Yat-sen University', '中山大学', 'SYSU', '综合', '28', '17', '20', '44', '0');
INSERT INTO `university` VALUES ('16', '10486', 'Wuhan University', '武汉大学', 'WHU', '综合', '25', '16', '21', '42', '0');
INSERT INTO `university` VALUES ('17', '10487', 'Huazhong University of Science and Technology', '华中科技大学', 'HUST', '工科', '27', '22', '25', '42', '0');
INSERT INTO `university` VALUES ('18', '10056', 'Tianjin University', '天津大学', 'TJU', '工科', '19', '23', '24', '12', '0');
INSERT INTO `university` VALUES ('19', '10384', 'Xiamen University', '厦门大学', 'XMU', '综合', '23', '24', '22', '35', '0');
INSERT INTO `university` VALUES ('20', '10286', 'Southeast University', '东南大学', 'SEU', '综合', '24', '19', '26', '32', '0');
INSERT INTO `university` VALUES ('21', '10007', 'Beijing Institute of Technology', '北京理工大学', 'BIT', '工科', '22', '25', '27', '11', '0');
INSERT INTO `university` VALUES ('22', '10034', 'Central University of Finance and Economics', '中央财经大学', 'CUFE', '财经', '13', '12', '15', '11', '0');
INSERT INTO `university` VALUES ('23', '10272', 'Shanghai University of Finance and Economics', '上海财经大学', 'SHUFE', '财经', '11', '11', '13', '31', '0');
INSERT INTO `university` VALUES ('24', '10036', 'University of International Business and Economics', '对外经济贸易大学', 'UIBE', '财经', '14', '14', '17', '11', '0');
INSERT INTO `university` VALUES ('25', '10013', 'Beijng University of Posts and Telecommunications', '北京邮电大学', 'BUPT', '工科', '20', '28', '30', '11', '0');
INSERT INTO `university` VALUES ('26', '10053', 'China Unverisity of Political Science and Law', '中国政法大学', 'CUPL', '政法', '21', '26', '29', '11', '0');
INSERT INTO `university` VALUES ('27', '10269', 'East China Normal Unversity', '华东师范大学', 'ECNU', '师范', '26', '32', '37', '31', '0');
INSERT INTO `university` VALUES ('28', '10422', 'Shandong Unversity', '山东大学', 'SDU', '综合', '30', '37', '39', '37', '0');
INSERT INTO `university` VALUES ('29', '10699', 'Northwestern Polytechnical University', '西北工业大学', 'NWPU', '工科', '35', '35', '35', '61', '0');
INSERT INTO `university` VALUES ('30', '10141', 'Dalian University of Technology', '大连理工大学', 'DLUT', '工科', '31', '43', '48', '21', '0');
INSERT INTO `university` VALUES ('31', '10019', 'China Agricultural University', '中国农业大学', 'CAU', '农业', '51', '51', '54', '11', '1');
INSERT INTO `university` VALUES ('32', '10533', 'Central South University', '中南大学', 'CSU', '综合', '49', '34', '40', '43', '0');
INSERT INTO `university` VALUES ('33', '10561', 'South China University of Technology', '华南理工大学', 'SCUT', '工科', '43', '27', '32', '44', '0');
INSERT INTO `university` VALUES ('34', '10610', 'Sichuan University', '四川大学', 'SCU', '综合', '42', '33', '38', '51', '0');
INSERT INTO `university` VALUES ('35', '10183', 'Jilin University', '吉林大学', 'JLU', '综合', '55', '50', '60', '22', '0');
INSERT INTO `university` VALUES ('36', '10532', 'Hunan University', '湖南大学', 'HNU', '综合', '57', '40', '51', '43', '0');
INSERT INTO `university` VALUES ('37', '10614', 'University of Electronic Science and Technology of China', '电子科技大学', 'UESTC', '工科', '45', '38', '42', '51', '0');
INSERT INTO `university` VALUES ('38', '10611', 'Chongqing University', '重庆大学', 'CQU', '综合', '58', '42', '45', '50', '0');
INSERT INTO `university` VALUES ('39', '10423', 'Ocean University of China', '中国海洋大学', 'OUC', '综合', '53', '58', '68', '37', '0');
INSERT INTO `university` VALUES ('40', '10559', 'Jinan University', '暨南大学', 'JNU', '综合', '68', '52', '53', '44', '0');
INSERT INTO `university` VALUES ('41', '10651', 'Southwestern University of Finance and Economics', '西南财经大学', 'SWUFE', '财经', '36', '31', '31', '51', '0');
INSERT INTO `university` VALUES ('42', '10004', 'Beijing Jiaotong University', '北京交通大学', 'BJTU', '工科', '33', '45', '41', '11', '0');
INSERT INTO `university` VALUES ('43', '10520', 'Zhongnan University of Economics and Law', '中南财经政法大学', 'ZUEL', '财经', '50', '36', '36', '42', '0');
INSERT INTO `university` VALUES ('44', '10287', 'Nanjing University of Aeronautics and Astronautics', '南京航空航天大学', 'NUAA', '工科', '37', '44', '43', '32', '0');
INSERT INTO `university` VALUES ('45', '10008', 'University of Science & Technology Beijing', '北京科技大学', 'USTB', '工科', '34', '47', '49', '11', '0');
INSERT INTO `university` VALUES ('46', '10079', 'North China Electric Power University', '华北电力大学', 'NCEPU', '工科', '39', '39', '58', '11', '0');
INSERT INTO `university` VALUES ('47', '10701', 'Xidian University', '西安电子科技大学', 'XIDIAN', '工科', '54', '54', '57', '61', '0');
INSERT INTO `university` VALUES ('48', '10251', 'East China University of Science and Technology', '华东理工大学', 'ECUST', '工科', '40', '48', '52', '31', '0');
INSERT INTO `university` VALUES ('49', '10288', 'Nanjing University of Science and Technology', '南京理工大学', 'NJUST', '工科', '52', '53', '62', '32', '0');
INSERT INTO `university` VALUES ('50', '10033', 'Communication University of China', '中国传媒大学', 'CUC', '语言', '38', '46', '47', '11', '0');
INSERT INTO `university` VALUES ('51', '10052', 'Minzu University of China', '中央民族大学', 'MUC', '民族', '76', '72', '81', '11', '1');
INSERT INTO `university` VALUES ('52', '10730', 'Lanzhou University', '兰州大学', 'LZU', '综合', '94', '70', '84', '62', '0');
INSERT INTO `university` VALUES ('53', '10145', 'Northeastern University', '东北大学', 'NEU', '工科', '69', '82', '88', '21', '0');
INSERT INTO `university` VALUES ('54', '10005', 'Beijng University of Technology', '北京工业大学', 'BJUT', '工科', '90', '78', '82', '11', '0');
INSERT INTO `university` VALUES ('55', '10280', 'Shanghai University', '上海大学', 'SHU', '综合', '70', '65', '75', '31', '0');
INSERT INTO `university` VALUES ('56', '10010', 'Beijing University of Chemical Technology', '北京化工大学', 'BUCT', '工科', '75', '81', '89', '11', '0');
INSERT INTO `university` VALUES ('57', '10613', 'Southwest Jiaotong University', '西南交通大学', 'SWJTU', '工科', '88', '60', '67', '51', '0');
INSERT INTO `university` VALUES ('58', '10285', 'Soochow University', '苏州大学', 'SUDA', '综合', '71', '63', '74', '32', '0');
INSERT INTO `university` VALUES ('59', '10511', 'Huazhong Normal University', '华中师范大学', 'HZNU', '师范', '96', '83', null, '42', '0');
INSERT INTO `university` VALUES ('60', '10022', 'Beijing Forestry University', '北京林业大学', 'BFU', '林业', '91', '96', '85', '11', '1');
INSERT INTO `university` VALUES ('61', '10497', 'Wuhan University of Technology', '武汉理工大学', 'WHUT', '工科', '92', '62', '73', '42', '0');
INSERT INTO `university` VALUES ('62', '10217', 'Harbin Engineering University', '哈尔滨工程大学', 'HRBEU', '工科', '84', '84', '91', '23', '0');
INSERT INTO `university` VALUES ('63', '10255', 'Donghua University', '东华大学', 'DHU', '工科', '77', '79', '78', '31', '0');
INSERT INTO `university` VALUES ('64', '10294', 'Hohai University', '河海大学', 'HHU', '工科', '78', '74', '76', '32', '0');
INSERT INTO `university` VALUES ('65', '10491', 'China University of Geosciences', '中国地质大学', 'CUGB', '工科', '93', '97', '96', '11', '0');
INSERT INTO `university` VALUES ('66', '11414', 'China University of Petroleum', '中国石油大学', 'CUP', '工科', '56', '68', '80', '11', '0');
INSERT INTO `university` VALUES ('67', '10710', 'Changan University', '长安大学', 'CHANGAN', '工科', '111', '98', '90', '61', '0');
INSERT INTO `university` VALUES ('68', '10151', 'Dalian Maritime University', '大连海事大学', 'DLMU', '工科', '82', '101', null, '21', '0');
INSERT INTO `university` VALUES ('69', '10359', 'Hefei University of Technology', '合肥工业大学', 'HFUT', '工科', '103', '106', null, '34', '0');
INSERT INTO `university` VALUES ('70', '10295', 'Jiangnan University', '江南大学', 'JIANGNAN', '综合', '107', '94', '97', '32', '0');
INSERT INTO `university` VALUES ('71', '10697', 'Northwest University', '西北大学', 'NWU', '综合', '102', '109', '100', '61', '0');
INSERT INTO `university` VALUES ('72', '10080', 'Hebei University of Technology', '河北工业大学', 'HEBUT', '工科', '118', '110', null, '13', '0');
INSERT INTO `university` VALUES ('73', '10386', 'Fuzhou University', '福州大学', 'FZU', '工科', '105', '102', null, '35', '0');
INSERT INTO `university` VALUES ('74', '10459', 'Zhengzhou University', '郑州大学', 'ZZU', '综合', '120', '107', null, '41', '0');
INSERT INTO `university` VALUES ('75', '10173', 'Dongbei University of Finance and Economics', '东北财经大学', 'DUFE', '财经', '44', '73', '61', '21', '0');
INSERT INTO `university` VALUES ('76', '10038', 'Capital University of Economics and Business', '首都经济贸易大学', 'CUEB', '财经', '59', '76', '70', '11', '0');
INSERT INTO `university` VALUES ('77', '10070', 'Tianjin University of Finance and Economics', '天津财经大学', 'TJUFE', '财经', '67', '71', null, '12', '0');
INSERT INTO `university` VALUES ('78', '10293', 'Nanjing University of Posts and Telecommunications', '南京邮电大学', 'NJUPT', '工科', '100', '105', '99', '32', '0');
INSERT INTO `university` VALUES ('79', '10276', 'East China University of Political Science and Law', '华东政法大学', 'ECUPL', '政法', '46', '69', '72', '31', '0');
INSERT INTO `university` VALUES ('80', '10590', 'Shenzhen University', '深圳大学', 'SZU', '综合', '83', '80', '86', '44', '0');
INSERT INTO `university` VALUES ('81', '10011', 'Beijing Technology and Business University', '北京工商大学', 'BTBU', '财经', '130', '134', null, '11', '0');
INSERT INTO `university` VALUES ('82', '10290', 'China University of Mining and Technology', '中国矿业大学', 'CUMT', '工科', '117', '112', null, '11', '0');
INSERT INTO `university` VALUES ('83', '10273', 'Shanghai University of International Business and Economics', '上海对外经贸大学', 'SUIBE', '财经', '48', '86', null, '31', '0');
INSERT INTO `university` VALUES ('85', '10030', 'Beijing Foreign Studies University', '北京外国语大学', 'BFSU', '语言', '15', '18', '28', null, '1');
INSERT INTO `university` VALUES ('86', '10271', 'Shanghai International Studies University', '上海外国语大学', 'SHISU', '语言', '18', '29', '33', null, '1');
INSERT INTO `university` VALUES ('87', '10025', 'Capital Medical University', '首都医科大学', 'CCMU', '医药', '32', '30', '46', null, '1');
INSERT INTO `university` VALUES ('88', '10032', 'Beijing Language and Culture University', '北京语言大学', 'BLCU', '语言', '41', '93', '92', null, '1');
INSERT INTO `university` VALUES ('89', '10312', 'Nanjing Medical University', '南京医科大学', 'NJMU', '医药', '47', '49', '55', null, '1');
INSERT INTO `university` VALUES ('90', '11287', 'Nanjing Audit University', '南京审计大学', 'NAU', '财经', '61', '64', '56', null, '1');
INSERT INTO `university` VALUES ('91', '11625', 'China Youth University of Political Studies', '中国青年政治学院', 'CYU', '政法', '62', null, null, null, '1');
INSERT INTO `university` VALUES ('92', '10159', 'China Medical University', '中国医科大学', 'CMU', '医药', '63', '56', '69', null, '1');
INSERT INTO `university` VALUES ('93', '10062', 'Tianjin Medical University', '天津医科大学', 'TIJMU', '医药', '64', '41', '50', null, '1');
INSERT INTO `university` VALUES ('94', '11482', 'Zhejiang University of Finance & Economics', '浙江财经大学', 'ZUFE', '财经', '65', null, null, null, '1');
INSERT INTO `university` VALUES ('95', '10327', 'Nanjing University of Finance & Economics', '南京财经大学', 'NJUFE', '财经', '85', '95', null, null, '0');
INSERT INTO `university` VALUES ('96', '10026', 'Beijing University of Chinese Medicine', '北京中医药大学', 'BUCM', '医药', '72', '59', '64', null, '1');
INSERT INTO `university` VALUES ('97', '10631', 'ChongQing Medical University', '重庆医科大学', 'CQMU', '医药', '73', '55', '63', null, '1');
INSERT INTO `university` VALUES ('98', '11047', 'Shanghai Lixin University of Accounting and Finance', '上海立信会计金融学院', 'LIXIN', '财经', '74', '118', null, null, '1');
INSERT INTO `university` VALUES ('99', '10316', 'China Pharmaceutical University', '中国药科大学', 'CPU', '医药', '79', '77', '79', null, '1');
INSERT INTO `university` VALUES ('100', '10042', 'University of International Relations', '国际关系学院', 'UIR', '政法', '81', null, null, null, '1');
INSERT INTO `university` VALUES ('101', '10031', 'Beijing International Studies University', '北京第二外国语大学', 'BISU', '语言', '86', '66', '71', null, '1');
INSERT INTO `university` VALUES ('102', '10161', 'Dalian Medical University', '大连医科大学', 'DLMEDU', '医药', '87', '88', null, null, '1');
INSERT INTO `university` VALUES ('103', '10343', 'Wenzhou Medical University', '温州医科大学', 'WMU', '医药', '89', '113', null, null, '1');
INSERT INTO `university` VALUES ('104', '10226', 'Harbin Medical University', '哈尔滨医科大学', 'HRBMU', '医药', '95', '85', null, null, '1');
INSERT INTO `university` VALUES ('105', '10337', 'Zhejiang University of Technology', '浙江工业大学', 'ZJUT', '工科', '97', '144', null, null, '0');
INSERT INTO `university` VALUES ('106', '10319', 'Nanjing Normal University', '南京师范大学', 'NJNU', '师范', '98', '114', null, null, '0');
INSERT INTO `university` VALUES ('107', '10652', 'Southwest University of Political Science & Law', '西南政法大学', 'SWUPT', '政法', '101', '103', '87', null, '0');
INSERT INTO `university` VALUES ('108', '10268', 'Shanghai University of Traditional Chinese Medicine', '上海中医药大学', 'SHUTCM', '医药', '104', '126', null, null, '1');
INSERT INTO `university` VALUES ('109', '12121', 'Southern Medical University', '南方医科大学', 'FIMMU', '医药', '106', '49', null, null, '1');
INSERT INTO `university` VALUES ('110', '10353', 'Zhejiang Gongshang University', '浙江工商大学', 'HZIC', '财经', '108', '123', null, null, '0');
INSERT INTO `university` VALUES ('111', '11846', 'Guangdong University of Foreign Studies', '广东外语外贸大学', 'GDUFS', '语言', '109', '75', null, null, '1');
INSERT INTO `university` VALUES ('112', '10028', 'Capital Normal University', '首都师范大学', 'CNU', '师范', '112', '138', null, null, '0');
INSERT INTO `university` VALUES ('113', '10366', 'Anhui Medical University', '安徽医科大学', 'AHMU', '医药', '113', '92', null, null, '1');
INSERT INTO `university` VALUES ('114', '10063', 'Tianjin University of Traditional Chinese Medicine', '天津中医药大学', 'TJUTCM', '医药', '114', '125', null, null, '1');
INSERT INTO `university` VALUES ('115', '10059', 'Civil Aviation University of China', '中国民航大学', 'CAUC', '工科', '115', '142', null, null, '1');
INSERT INTO `university` VALUES ('116', '10089', 'Hebei Medical University', '河北医科大学', 'HEBMU', '医药', '116', '67', null, null, '1');
INSERT INTO `university` VALUES ('117', '10188', 'Northeast Electric Power University', '东北电力大学', 'NEEPU', '工科', '119', null, null, null, '1');
INSERT INTO `university` VALUES ('118', '10760', 'Xinjiang medical university', '新疆医科大学', 'XJMU', '医药', '121', '154', null, null, '1');
INSERT INTO `university` VALUES ('119', '10254', 'Shanghai Maritime University', '上海海事大学', 'SHMTU', '工科', '122', '136', null, null, '0');
INSERT INTO `university` VALUES ('120', '10068', 'Tianjin Foreign Studies University', '天津外国语大学', 'TJFSU', '语言', '123', '149', null, null, '1');
INSERT INTO `university` VALUES ('121', '10037', 'Beijing Wuzi University', '北京物资学院', 'BWU', '财经', '124', null, null, null, '1');
INSERT INTO `university` VALUES ('122', '16301', 'The University of Nottingham Ningbo China', '宁波诺丁汉大学', 'NOTTINGH', '综合', '125', '145', null, null, '1');
INSERT INTO `university` VALUES ('123', '10200', 'Northeast Normal University', '东北师范大学', 'NENU', '师范', '126', '146', null, null, '0');
INSERT INTO `university` VALUES ('124', '10598', 'Guangxi Medical University', '广西医科大学', 'GXMU', '医药', '128', '100', null, null, '1');
INSERT INTO `university` VALUES ('125', '10252', 'University of Shanghai for Science and Technology', '上海理工大学', 'USST', '工科', '129', '111', null, null, '0');
INSERT INTO `university` VALUES ('126', '10421', 'Jiangxi University of Finance and Economics', '江西财经大学', 'JXUFE', '财经', '132', '91', null, null, '0');
INSERT INTO `university` VALUES ('127', '10216', 'Yanshan University', '燕山大学', 'YSU', '工科', '133', '132', null, null, '0');
INSERT INTO `university` VALUES ('128', '10390', 'JiMei University', '集美大学', 'JMU', '综合', '134', '207', null, null, '0');
INSERT INTO `university` VALUES ('129', '10718', 'Shaanxi Normal University', '陕西师范大学', 'SNNU', '师范', '135', '152', null, null, '0');
INSERT INTO `university` VALUES ('130', '10673', 'Yunnan University', '云南大学', 'YNU', '综合', '136', '140', null, null, '0');
INSERT INTO `university` VALUES ('131', '11065', 'Qingdao University', '青岛大学', 'QDU', '综合', '137', '157', null, null, '0');
INSERT INTO `university` VALUES ('132', '10016', 'Beijing University of Civil Engineering and Architecture', '北京建筑大学', 'BUCEA', '工科', '138', '122', null, null, '0');
INSERT INTO `university` VALUES ('134', '10340', 'Zhejiang Ocean University', '浙江海洋大学', 'ZJOU', '农业', '139', '238', null, null, '1');
INSERT INTO `university` VALUES ('135', '10172', 'Dalian University of Foreign Languages', '大连外国语大学', 'DLUFL', '语言', '140', null, null, null, '1');
INSERT INTO `university` VALUES ('136', '10635', 'Southwest University', '西南大学', 'SWU', '综合', '142', '116', null, null, '0');
INSERT INTO `university` VALUES ('137', '11646', 'Ningbo University', '宁波大学', 'NBU', '综合', '143', '158', null, null, '0');
INSERT INTO `university` VALUES ('138', '10357', 'Anhui University', '安徽大学', 'AHU', '综合', '144', '120', null, null, '0');
INSERT INTO `university` VALUES ('139', '10703', 'Xian University of Architecture and Technology', '西安建筑科技大学', 'XAUAT', '工科', '145', '115', null, null, '0');
INSERT INTO `university` VALUES ('140', '10140', 'Liaoning University', '辽宁大学', 'LNU', '综合', '146', '133', null, null, '0');
INSERT INTO `university` VALUES ('141', '10126', 'Inner Mongolia University', '内蒙古大学', 'IMU', '综合', '147', '196', null, null, '0');
INSERT INTO `university` VALUES ('142', '10163', 'Shenyang Pharmaceutical University', '沈阳药科大学', 'SYPHU', '医药', '148', '167', null, null, '1');
INSERT INTO `university` VALUES ('143', '10299', 'Jiangsu University', '江苏大学', 'UJS', '综合', '149', '139', null, null, '0');
INSERT INTO `university` VALUES ('144', '10300', 'Nanjing University of Information Science & Technology', '南京信息工程大学', 'NUIST', '工科', '150', '130', null, null, '1');
INSERT INTO `university` VALUES ('145', '10574', 'South China Normal University', '华南师范大学', 'SCNU', '师范', '184', '121', '93', null, '0');
INSERT INTO `university` VALUES ('146', '10560', 'Shantou University', '汕头大学', 'STU', '综合', '185', '108', null, null, '0');
INSERT INTO `university` VALUES ('147', '10114', 'Shanxi Medical University', '山西医科大学', 'SXMU', '医药', '154', '89', null, null, '1');
INSERT INTO `university` VALUES ('148', '10403', 'Nanchang University', '南昌大学', 'NCU', '综合', '186', '117', null, null, '0');
INSERT INTO `university` VALUES ('149', '10572', 'Guangzhou University of Chinese Medicine', '广州中医药大学', 'GZUCM', '医药', '216', '119', null, null, '1');
INSERT INTO `university` VALUES ('150', '10112', 'Taiyuan University of Technology', '太原理工大学', 'TYUT', '工科', '168', '124', null, null, '0');
INSERT INTO `university` VALUES ('151', '10712', 'Northwest A&F University', '西北农林科技大学', 'NWSUAF', '农业', '171', '127', null, null, '1');
INSERT INTO `university` VALUES ('152', '10724', 'Xian International Studies University', '西安外国语大学', 'XISU', '语言', '160', '128', null, null, '1');
INSERT INTO `university` VALUES ('153', '10291', 'Nanjing Tech University', '南京工业大学', 'NJTECH', '工科', '162', '129', null, null, '0');
INSERT INTO `university` VALUES ('154', '10542', 'Hunan Normal University', '湖南师范大学', 'HUNNU', '师范', '152', '131', null, null, '0');
INSERT INTO `university` VALUES ('155', '10336', 'Hangzhou Dianzi University', '杭州电子科技大学', 'HDU', '工科', '158', '141', null, null, '0');
INSERT INTO `university` VALUES ('156', '10617', 'Chongqing University of Posts and Telecommunications', '重庆邮电大学', 'CQUPT', '工科', '188', '148', null, null, '0');
INSERT INTO `university` VALUES ('158', '10726', 'Northwest University of Political Science and Law', '西北政法大学', 'NWUPL', '政法', '151', '149', null, null, '0');
INSERT INTO `university` VALUES ('159', '10488', 'Wuhan University of Science and Technology', '武汉科技大学', 'WUST', '工科', '209', '150', null, null, '0');
