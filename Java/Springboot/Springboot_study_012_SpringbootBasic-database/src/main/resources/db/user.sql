SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	id int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	username VARCHAR(10) NOT NULL DEFAULT 'Guest' COMMENT '姓名',
	--	1-male 2-female
	sex int(3) NOT Null default 1 comment '性别',
	note varchar(200) null,
	PRIMARY KEY (id)
);

-- ----------------------------
-- Records of user
-- ----------------------------
DELETE FROM user;

INSERT INTO user (id, username, sex, note) VALUES
(1, 'Jean', 1, 'Jean is a singer.'),
(2, 'Jack', 1, 'Jack is a football player.'),
(3, 'Anna', 2, 'Anna is a princees.'),
(4, 'Sandy', 2, 'Sandy is a dancer.'),
(5, 'Billie', 1, 'Billie is a gay.'),
(6, 'Tom', 1, 'Tom is a cat.');
