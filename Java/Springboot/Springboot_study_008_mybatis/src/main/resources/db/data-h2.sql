SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	username VARCHAR(10) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	sex varchar(10) null default null comment '性别',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);

-- ----------------------------
-- Records of user
-- ----------------------------
DELETE FROM user;

INSERT INTO user (id, username, age, sex, email) VALUES
(1, 'Jone', 18, 'Man', 'test1@baomidou.com'),
(2, 'Jack', 20, 'Man', 'test2@baomidou.com'),
(3, 'Tom', 28, 'Man', 'test3@baomidou.com'),
(4, 'Sandy', 21, 'Femal', 'test4@baomidou.com'),
(5, 'Billie', 24, 'Man', 'test5@baomidou.com');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS login;

CREATE TABLE login
(
	id bigint(20) not null comment '主键ID',
	username varchar(10) not null comment '用户名',
	password varchar(30) not null comment '密码',
);

-- ----------------------------
-- Records of login
-- ----------------------------
DELETE FROM login;

INSERT INTO login (id, username, password) VALUES
(1, 'Jone', 'Jone'),
(2, 'Jack', 'Jack'),
(3, 'Tom', 'Tom'),
(4, 'Sandy', 'Sandy'),
(5, 'Billie', 'Billie');


-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS job;
CREATE TABLE job  (
	log_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
 	job_id bigint(20) NOT NULL COMMENT '任务id',
 	bean_name varchar(100) COMMENT 'spring bean名称',
	method_name varchar(100) COMMENT '方法名',
    params varchar(200)  COMMENT '参数',
	status char(2) COMMENT '任务状态    0：成功    1：失败',
	error text COMMENT '失败信息',
	times decimal(11, 0) NULL DEFAULT NULL COMMENT '耗时(单位：毫秒)',
	create_time datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (log_id)
);

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO job VALUES (2472, 2, 'testTask', 'test1', NULL, '0', NULL, 14, '2018-04-02 17:29:50');


-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS department;

CREATE TABLE department
(
	id BIGINT(20) NOT NULL COMMENT '主键部门ID',
	user_id BIGINT(20) NOT NULL COMMENT '用户ID',
	code CHAR(4) NOT NULL COMMENT '部门代号',
	name VARCHAR(20) NULL DEFAULT NULL COMMENT '部门名',
	PRIMARY KEY (id)
);

-- ----------------------------
-- Records of department
-- ----------------------------
DELETE FROM department;

INSERT INTO department (id, user_id, code, name) VALUES
(01, 1, 'D001', 'Administration'),
(02, 2, 'D002', 'Engineering'),
(03, 3, 'D003', 'Finance'),
(04, 4, 'D004', 'Human Resouces'),
(05, 5, 'D005', 'Legal Affairs');