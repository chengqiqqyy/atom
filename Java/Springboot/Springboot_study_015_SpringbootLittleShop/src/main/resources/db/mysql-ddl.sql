/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 27/09/2019 19:09:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS t_admin;
CREATE TABLE t_admin  (
  admin_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  username varchar(16) NOT NULL COMMENT '用户名',
  password varchar(32) NOT NULL COMMENT '密码',
  PRIMARY KEY (admin_id)
);

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO t_admin VALUES (1, '2019-09-25 15:42:53', '2019-09-25 15:42:53', 'admin', 'admin');

-- ----------------------------
-- Table structure for t_announcement
-- ----------------------------
DROP TABLE IF EXISTS t_announcement;
CREATE TABLE t_announcement  (
  announcement_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  content varchar(512)  NOT NULL COMMENT '公告内容',
  create_admin_id bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  update_admin_id bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (announcement_id)
);

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS t_news;
CREATE TABLE t_news  (
  news_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  title varchar(64)  NOT NULL COMMENT '标题',
  content varchar(512)  NOT NULL COMMENT '内容',
  create_user_id bigint(20) NULL DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (news_id)
);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS t_order;
CREATE TABLE t_order  (
  order_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  order_number varchar(64)  NOT NULL COMMENT '订单编号',
  zipcode varchar(8)  NOT NULL COMMENT '收货邮编',
  address varchar(512)  NOT NULL COMMENT '收货地址',
  consignee varchar(16)  NOT NULL COMMENT '收货人',
  phone varchar(16)  NOT NULL COMMENT '收货人电话',
  final_price double NOT NULL COMMENT '实际成交价',
  total_price double NOT NULL COMMENT '总价',
  pay_time timestamp(0) NOT NULL COMMENT '付款时间',
  ship_time timestamp(0) NOT NULL COMMENT '发货时间',
  status int(2) NOT NULL COMMENT '订单状态',
  confirm_time timestamp(0) NOT NULL COMMENT '确认收货时间',
  user_id bigint(20) NOT NULL COMMENT '关联客户',
  PRIMARY KEY (order_id)
);

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO t_order VALUES (1, '2019-09-27 13:46:33', '2019-09-27 13:46:32', '20190927134667', '430050', '琥珀县琥珀市天空之城520-283', '琥珀猫', '23323332333', 2788, 2788, '2019-09-27 18:52:12', '2019-09-27 19:01:21', 1, '2019-09-27 19:08:21', 1);

-- ----------------------------
-- Table structure for t_orderstatus
-- ----------------------------
DROP TABLE IF EXISTS t_orderstatus;
CREATE TABLE t_orderstatus (
  order_status_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单状态ID',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  status varchar(20) NULL DEFAULT NULL COMMENT '订单状态名',
  PRIMARY KEY (order_status_id)
);

-- ----------------------------
-- Table structure for t_orderitem
-- ----------------------------
DROP TABLE IF EXISTS t_orderitem;
CREATE TABLE t_orderitem  (
  order_item_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  quantity int(11) NOT NULL COMMENT '订单数量',
  order_id bigint(20) NULL DEFAULT NULL COMMENT '主键',
  product_id bigint(20) NULL DEFAULT NULL COMMENT '主键',
  PRIMARY KEY (order_item_id)
);

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------
INSERT INTO t_orderitem VALUES (1, '2019-09-27 13:46:32', '2019-09-27 13:46:32', 1, 1, 1);

-- ----------------------------
-- Table structure for t_payment
-- ----------------------------
DROP TABLE IF EXISTS t_payment;
CREATE TABLE t_payment  (
  payment_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  payer_name varchar(20)  NOT NULL COMMENT '付款人名字',
  order_id bigint(20) NOT NULL COMMENT '订单ID',
  PRIMARY KEY (payment_id)
);

-- ----------------------------
-- Table structure for t_picture
-- ----------------------------
DROP TABLE IF EXISTS t_picture;
CREATE TABLE t_picture  (
  picture_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  title varchar(32)  NOT NULL COMMENT '图片名称',
  memo varchar(128)  NOT NULL COMMENT '图片描述',
  url varchar(64)  NOT NULL COMMENT '图片地址',
  create_admin_id bigint(20) NOT NULL DEFAULT 0 COMMENT '创建者',
  update_admin_id bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (picture_id)
);

-- ----------------------------
-- Records of t_picture
-- ----------------------------
INSERT INTO t_picture VALUES (1, '2019-09-25 15:49:09', '2019-09-25 15:49:09', '商品上传', '商品上传', '/img/1569397749301.jpg', 1, 1);

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS t_product;
CREATE TABLE t_product  (
  product_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  product_name varchar(64)  NOT NULL COMMENT '商品名称',
  model varchar(32)  NOT NULL COMMENT '商品型号',
  code varchar(32)  NOT NULL COMMENT '商品编码',
  note text  NULL COMMENT '商品描述',
  price double NOT NULL COMMENT '商品价格',
  stock int(11) NOT NULL COMMENT '库存数量',
  product_type_id bigint(20) NULL DEFAULT NULL COMMENT '主键',
  master_pic_id bigint(20) NULL DEFAULT NULL COMMENT '主键',
  slave_pic_id bigint(20) NULL DEFAULT NULL COMMENT '主键',
  PRIMARY KEY (product_id)
);

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO t_product VALUES (1, '2019-09-25 15:49:09', '2019-09-25 15:49:09', '七彩虹RTX2080TI', 'RTX2080TI', 'DC00001', '七彩虹RTX2080TI', 2888, 12, 1, 1, 1);

-- ----------------------------
-- Table structure for t_producttype
-- ----------------------------
DROP TABLE IF EXISTS t_producttype;
CREATE TABLE t_producttype  (
  product_type_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  product_type_name varchar(32)  NOT NULL COMMENT '分类名称',
  PRIMARY KEY (product_type_id)
);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user  (
  user_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  username varchar(32)  NOT NULL COMMENT '用户名',
  password varchar(64)  NOT NULL COMMENT '密码',
  remember_me int NOT NULL DEFAULT 0 COMMENT '免登入',
  account varchar(32)  NULL DEFAULT NULL COMMENT '账号(暂时没用)',
  address varchar(64)  NULL DEFAULT NULL COMMENT '地址',
  balance double NOT NULL DEFAULT 0 COMMENT '账户余额',
  phone varchar(32)  NULL DEFAULT NULL COMMENT '手机号码',
  point int NOT NULL DEFAULT 0 COMMENT '积分值',
  note varchar(32)  NULL DEFAULT NULL COMMENT '签名',
  slat varchar(64)  NULL DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (user_id)
);

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES (1, '2019-09-25 15:44:06', '2019-09-25 15:44:06', 'user1', '123456', 0, NULL, NULL, 0, '23323332333', 0, NULL, NULL);

-- ----------------------------
-- Table structure for t_useraddress
-- ----------------------------
DROP TABLE IF EXISTS t_shippingaddress;
CREATE TABLE t_shippingaddress  (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  zipcode varchar(16)  NULL DEFAULT NULL COMMENT '邮编',
  address varchar(64)  NULL DEFAULT NULL COMMENT '收货地址',
  consignee varchar(16)  NULL DEFAULT NULL COMMENT '收货人',
  phone varchar(32)  NULL DEFAULT NULL COMMENT '手机号',
  user_id bigint(20) NULL DEFAULT NULL COMMENT '主键',
  PRIMARY KEY (id)
);

-- ----------------------------
-- Records of t_useraddress
-- ----------------------------
INSERT INTO t_shippingaddress VALUES (1, '2019-09-27 13:46:32', '2019-09-27 13:46:32', '430050', '琥珀县琥珀市天空之城520-283', '琥珀猫', '23323332333', 1);

SET FOREIGN_KEY_CHECKS = 1;
