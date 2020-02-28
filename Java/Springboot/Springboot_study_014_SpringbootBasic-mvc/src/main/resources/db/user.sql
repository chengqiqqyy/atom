SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE user
(
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	username VARCHAR(10) NOT NULL DEFAULT 'Guest' COMMENT '姓名',
	password varchar(200) NOT NULL,
	PRIMARY KEY (id)
);


-- ----------------------------
-- Records of user
-- ----------------------------

INSERT INTO user (username, password) VALUES
('Admin', 'a339f1df5b6230b633f7611bf117d490');
