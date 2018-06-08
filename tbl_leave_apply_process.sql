/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : activiti-explorer

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-06-08 11:31:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_leave_apply_process
-- ----------------------------
DROP TABLE IF EXISTS `tbl_leave_apply_process`;
CREATE TABLE `tbl_leave_apply_process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_key` varchar(255) DEFAULT '' COMMENT '流程定义id',
  `process_order_id` varchar(255) NOT NULL COMMENT '流程实例id',
  `task_id` varchar(255) DEFAULT NULL,
  `business_id` varchar(255) NOT NULL COMMENT '业务相关ID',
  `role_name` varchar(255) NOT NULL COMMENT '可以查看任务的角色权限',
  `def_key` varchar(255) NOT NULL COMMENT '流程实例状态(流程节点）',
  `operator` varchar(255) NOT NULL COMMENT '操作人',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='snaker-借款流程业务工作流表';
