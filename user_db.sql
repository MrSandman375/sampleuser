/*
Navicat MySQL Data Transfer

Source Server         : 49.232.44.6
Source Server Version : 50727
Source Host           : 49.232.44.6:3306
Source Database       : user_db

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2021-03-01 13:45:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mobile` varchar(32) DEFAULT NULL COMMENT '登录名，使用电话号码作为登录名',
  `password` varchar(64) DEFAULT NULL COMMENT '登录密码',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `birthdate` datetime DEFAULT NULL COMMENT '出生日期',
  `address` varchar(250) DEFAULT NULL COMMENT '详细地址',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `state` varchar(32) DEFAULT NULL COMMENT '-1:表示删除 ，1：正常状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户表';
