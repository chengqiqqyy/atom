SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE user
(
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	username VARCHAR(10) NOT NULL DEFAULT 'Guest' COMMENT '姓名',
	--	1-male 2-female
	sex int(3) NOT Null default 1 comment '性别',
	note varchar(200) null,
	PRIMARY KEY (id)
);


-- ----------------------------
-- Records of user
-- ----------------------------

INSERT INTO user (username, sex, note) VALUES
('Jean', 1, 'Jean is a singer.'),
('Jack', 1, 'Jack is a football player.'),
('Anna', 2, 'Anna is a princees.'),
('Sandy', 2, 'Sandy is a dancer.'),
('Billie', 1, 'Billie is a gay.'),
('Tom', 1, 'Tom is a cat.');
