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
	password CHAR(32) NOT NULL COMMENT '密码',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	sex varchar(10) null default null comment '性别',
	status INT(1) NOT　NULL COMMENT '状态',
	PRIMARY KEY (id)
);

-- ----------------------------
-- Records of user
-- ----------------------------
DELETE FROM user;

INSERT INTO user (id, username,　password, age, sex, status) VALUES
(1, 'Jone', 'e939994bbdef8736e640ad5a6dbeca4b', 18, 'Man', 1),
(2, 'Jack', 'ec9d4fa8c35c220a94582a4ef829d672', 20, 'Man', 1),
(3, 'Tom', '73924cbc55b5bfc8197e35d0f0f812f4', 28, 'Man', 0),
(4, 'Sandy', '136cf1c4c36e188c38ab6682b10ebf33', 21, 'Femal', 1),
(5, 'Billie', '321ff5de271eb9f07e7d641d7e309920', 24, 'Man', 1),
(6, 'test', 'dff65fbf07cdbb86aeda42cf4c207d0d', 24, 'Man', 1);
