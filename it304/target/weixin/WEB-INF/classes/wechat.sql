/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : wechat

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-11-06 13:33:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试表(无意义)';

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for textformat
-- ----------------------------
DROP TABLE IF EXISTS `textformat`;
CREATE TABLE `textformat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyWord` varchar(255) DEFAULT NULL COMMENT '关键字',
  `news` varchar(255) DEFAULT NULL COMMENT '回复的消息',
  `available` int(255) DEFAULT NULL COMMENT '是否可用(1可用,其他为不可用)',
  `explanation` varchar(255) DEFAULT NULL COMMENT '关键字的说明',
  `operatingType` int(255) DEFAULT NULL COMMENT '操作类型(1,直接返回,二数据库操作(增删改))',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文本消息回复表';

-- ----------------------------
-- Records of textformat
-- ----------------------------
INSERT INTO `textformat` VALUES ('1', '-1', '我去,程序猿那群单身狗没设计回复这条指令的命令,要不您试试输入\"help\"或\"帮助\"?', '0', '找不到关键字是回复', '1');
