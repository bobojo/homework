/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : jdbc_day

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 11/12/2021 22:37:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `SNO` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Age` int(11) NULL DEFAULT NULL,
  `College` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SNO`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('s001', '老大', 20, '通信学院');
INSERT INTO `student` VALUES ('s002', '老二', 19, '计算机学院');
INSERT INTO `student` VALUES ('s003', '老三', 18, '计算机学院');

SET FOREIGN_KEY_CHECKS = 1;
