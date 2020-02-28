SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);

DELETE FROM user;

INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');

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
INSERT INTO job VALUES (2473, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02 17:30:00');
INSERT INTO job VALUES (2474, 2, 'testTask', 'test1', NULL, '0', NULL, 0, '2018-04-02 17:30:10');
INSERT INTO job VALUES (2475, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02 17:30:20');
INSERT INTO job VALUES (2476, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 08:49:24');
INSERT INTO job VALUES (2477, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 08:49:25');
INSERT INTO job VALUES (2478, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 08:49:26');
INSERT INTO job VALUES (2479, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 08:49:27');
INSERT INTO job VALUES (2480, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 08:49:28');
INSERT INTO job VALUES (2481, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 08:49:29');
INSERT INTO job VALUES (2482, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 08:49:30');
INSERT INTO job VALUES (2483, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 08:49:31');
INSERT INTO job VALUES (2484, 1, 'testTask', 'test', 'mrbird', '0', NULL, 4, '2019-06-11 10:43:36');
INSERT INTO job VALUES (2485, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:37');
INSERT INTO job VALUES (2486, 1, 'testTask', 'test', 'mrbird', '0', NULL, 15, '2019-06-11 10:43:38');
INSERT INTO job VALUES (2487, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:39');
INSERT INTO job VALUES (2488, 1, 'testTask', 'test', 'mrbird', '0', NULL, 53, '2019-06-11 10:43:40');
INSERT INTO job VALUES (2489, 1, 'testTask', 'test', 'mrbird', '0', NULL, 3, '2019-06-11 10:43:41');
INSERT INTO job VALUES (2490, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:43:42');
INSERT INTO job VALUES (2491, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:43');
INSERT INTO job VALUES (2492, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-06-11 10:43:44');
INSERT INTO job VALUES (2493, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:45');
INSERT INTO job VALUES (2494, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:46');
INSERT INTO job VALUES (2495, 1, 'testTask', 'test', 'mrbird', '0', NULL, 13, '2019-06-11 10:43:47');
INSERT INTO job VALUES (2496, 1, 'testTask', 'test', 'mrbird', '0', NULL, 35, '2019-06-11 10:43:48');
INSERT INTO job VALUES (2497, 1, 'testTask', 'test', 'mrbird', '0', NULL, 3, '2019-06-11 10:43:49');
INSERT INTO job VALUES (2498, 1, 'testTask', 'test', 'mrbird', '0', NULL, 7, '2019-06-11 10:43:50');
INSERT INTO job VALUES (2499, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:51');
INSERT INTO job VALUES (2500, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:52');
INSERT INTO job VALUES (2501, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:43:53');
INSERT INTO job VALUES (2502, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:54');
INSERT INTO job VALUES (2503, 1, 'testTask', 'test', 'mrbird', '0', NULL, 14, '2019-06-11 10:43:55');
INSERT INTO job VALUES (2504, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:43:56');
INSERT INTO job VALUES (2505, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:57');
INSERT INTO job VALUES (2506, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:43:58');
INSERT INTO job VALUES (2507, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:43:59');
INSERT INTO job VALUES (2508, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:44:00');
INSERT INTO job VALUES (2509, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:01');
INSERT INTO job VALUES (2510, 1, 'testTask', 'test', 'mrbird', '0', NULL, 37, '2019-06-11 10:44:02');
INSERT INTO job VALUES (2511, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:03');
INSERT INTO job VALUES (2512, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:04');
INSERT INTO job VALUES (2513, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:05');
INSERT INTO job VALUES (2514, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-06-11 10:44:06');
INSERT INTO job VALUES (2515, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:44:07');
INSERT INTO job VALUES (2516, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:08');
INSERT INTO job VALUES (2517, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:09');
INSERT INTO job VALUES (2518, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:10');
INSERT INTO job VALUES (2519, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:11');
INSERT INTO job VALUES (2520, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:12');
INSERT INTO job VALUES (2521, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:13');
INSERT INTO job VALUES (2522, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:16');
INSERT INTO job VALUES (2523, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:16');
INSERT INTO job VALUES (2524, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:16');
INSERT INTO job VALUES (2525, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:17');
INSERT INTO job VALUES (2526, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:18');
INSERT INTO job VALUES (2527, 1, 'testTask', 'test', 'mrbird', '0', NULL, 145, '2019-06-11 10:44:19');
INSERT INTO job VALUES (2528, 1, 'testTask', 'test', 'mrbird', '0', NULL, 11, '2019-06-11 10:44:20');
INSERT INTO job VALUES (2529, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:21');
INSERT INTO job VALUES (2530, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:22');
INSERT INTO job VALUES (2531, 1, 'testTask', 'test', 'mrbird', '0', NULL, 206, '2019-06-11 10:44:23');
INSERT INTO job VALUES (2532, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-06-11 10:44:24');
INSERT INTO job VALUES (2533, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-06-11 10:44:25');
INSERT INTO job VALUES (2534, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:26');
INSERT INTO job VALUES (2535, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-06-11 10:44:27');
INSERT INTO job VALUES (2536, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:44:28');
INSERT INTO job VALUES (2537, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:45:54');
INSERT INTO job VALUES (2538, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:45:55');
INSERT INTO job VALUES (2539, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:45:56');
INSERT INTO job VALUES (2540, 1, 'testTask', 'test', 'mrbird', '0', NULL, 4, '2019-06-11 10:45:57');
INSERT INTO job VALUES (2541, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:45:58');
INSERT INTO job VALUES (2542, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:45:59');
INSERT INTO job VALUES (2543, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-06-11 10:46:00');
INSERT INTO job VALUES (2544, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:46:01');
INSERT INTO job VALUES (2545, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:46:02');
INSERT INTO job VALUES (2546, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-06-11 10:46:03');
INSERT INTO job VALUES (2547, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:46:04');
INSERT INTO job VALUES (2548, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-06-11 10:46:05');
INSERT INTO job VALUES (2549, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:46:06');
INSERT INTO job VALUES (2550, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:46:07');
INSERT INTO job VALUES (2551, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:46:45');
INSERT INTO job VALUES (2552, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:46:46');
INSERT INTO job VALUES (2553, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:46:47');
INSERT INTO job VALUES (2554, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:46:48');
INSERT INTO job VALUES (2555, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:46:49');
INSERT INTO job VALUES (2556, 1, 'testTask', 'test', 'mrbird', '0', NULL, 10, '2019-06-11 10:46:50');
INSERT INTO job VALUES (2557, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:46:51');
INSERT INTO job VALUES (2558, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:46:52');
INSERT INTO job VALUES (2559, 1, 'testTask', 'test', 'mrbird', '0', NULL, 2, '2019-06-11 10:46:53');
INSERT INTO job VALUES (2560, 1, 'testTask', 'test', 'mrbird', '0', NULL, 0, '2019-06-11 10:46:54');
INSERT INTO job VALUES (2561, 1, 'testTask', 'test', 'mrbird', '0', NULL, 1, '2019-06-11 10:46:55');
