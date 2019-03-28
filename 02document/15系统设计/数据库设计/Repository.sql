-- 事项进展表结构
-- statu_id  		状态id
-- item_code 		事项id
-- statu_describe 	状态描述
-- opt_time 		操作时间
-- user_id  		操作人
-- sup_statu		督办员操作	0:未完成  1:已完成  2:退回
-- org_statu		部门操作	0:未完成  1:已完成  2:退回
-- staff_statu		员工操作	0:未完成  1:已完成  2:退回

-- 事项进展表数据插入
INSERT INTO item_process(item_code,statu_describe,opt_time,user_id,sup_statu,org_statu,staff_statu) VALUES 
			(5,'已完结','2019-03-18 17:59:59',7,1,1,1),
			(6,'已完结','2018-12-24 17:59:59',5,1,1,1),
			(7,'已完结','2018-12-31 17:59:59',2,1,1,1),
			(8,'已完结','2019-01-02 14:00:00',1,1,1,1),
			(9,'推进中','2019-02-25 09:00:00',6,0,0,0),
			(10,'推进中','2019-03-25 14:00:00',4,0,0,0),
			(11,'已完结','2019-01-18 17:59:59',1,1,1,1),
			(12,'已完结','2019-01-25 12:00:00',3,1,1,1),
			(13,'已完结','2019-02-01 17:59:59',4,1,1,1),
			(14,'已完结','2019-02-03 12:00:00',1,1,1,1),
			(15,'已完结','2019-02-12 12:00:00',1,1,1,1);


-- 备用库表结构
-- id			事项id
-- source_id		来源id
-- source_time		来源时间
-- serial_num		流水号
-- file_type		文件类型id
-- drafter		原件拟稿人
-- drafter_phone	拟稿人联系方式
-- item_name		事项名称
-- item_code		事项编号
-- user_id		批示的领导id
-- org_id		来源部门
-- secrecy_level	保密等级id
-- item_content		事项内容
-- over_time		结束时间
-- feedback		反馈频率
-- next_feedback	下次反馈时间
-- dept_opinion		部门意见
-- lead_opinion		领导意见
-- item_statu		事项状态	0:已删除  1:未删除
-- item_type		事项类型	0:新增  1:同步  2:退回
-- remark 		备注


-- 备用库数据插入
INSERT INTO repository(id,source_id,source_time,serial_num,file_type,drafter,drafter_phone,item_name,item_code,user_id,org_id,secrecy_level,item_content,over_time,feedback,next_feedback,dept_opinion,lead_opinion,item_statu,item_type,remark) VALUES 
		       (5,1,'2018-12-11 09:06:12',1231,3,'杜宇','13113311524','官微建设','5',1,4,4,'打造官方宣传平台,提升平台影响力','2019-03-21 09:00:00',7,'2018-12-18 09:06:12','全力支持','尽快落实',1,1,'只可将任务提前完成，不得超时'),
		       (6,2,'2018-12-16 15:00:00',1046,1,'陈如初','15346289375','筹备双旦活动','6',2,5,3,'给学生们一个惊喜，度过愉快的节日','2018-12-25 00:00:00',4,'2018-12-20 10:00:00',NULL,'尽善尽美',1,1,NULL),
		       (7,3,'2018-12-28 11:00:00',1069,4,'任明','15679542683','拟定新年计划','7',1,1,2,'新的一年即将到来，将新年工作与计划制定好','2019-01-01 00:00:00',1,'2018-12-29 09:00:00','实施中','务求详尽',1,1,NULL),
		       (8,2,'2019-01-02 10:00:00',1901,2,'贾定','17307426851','各部门新年计划表提交','8',1,1,1,'各部门将本部门所制定的2019年计划报表统一提交','2019-01-02 18:00:00',0,'2019-01-02 17:59:59','同意','下班前须提交完毕',1,1,NULL),
		       (9,1,'2019-01-05 09:02:00',1902,1,'简登隆','18709152386','培养员工对公司的自豪感','9',2,3,3,'召开集体会议,鼓励元旦过后捡灯笼的员工积极进取,同时号召其他员工学习','2080-12-31 23:59::59',30,'2019-02-05 10:00:00','正在培养部门员工捡灯笼的自豪感','甚感欣慰',1,1,'公司不倒,培养自豪感到老'),
		       (10,3,'2019-01-08 16:36:24',1903,3,'陆沉','0731-123456','抵御寒冬','10',2,2,2,'互联网寒冬已至,全员学习先进技术,提升硬实力','2019-03-31 10:00:00',10,'2019-01-18 13:30:00','积极进取,勇争上游','活到老，学到老',1,1,'大家加油'),
		       (11,2,'2019-01-15 10:00:00',1904,1,'陈芝豹','18672943685','结构优化','11',1,1,3,'公司人员冗余,需优化内部结构','2019-01-20 17:59:59',1,'2019-01-16 10:00:00','阻力颇多','优化人员请尽快完成工作交接',1,1,NULL),
		       (12,2,'2019-01-20 14:00:00',1905,4,'荀渊','18723985261','项目竞标准备','12',2,2,1,'做好竞标准备,务求竞标成功','2019-01-25 17:59:59',1,'2019-01-21 14:00:00','准备中','越完善越好',1,1,NULL),
		       (13,3,'2019-01-26 09:00:00',1906,3,'崔瀺','19023685417','拟定项目流程','13',2,2,2,'项目竞标成功，拟定项目流程,确定各阶段任务','2019-02-02 17:00:00',1,'2019-01-27 17:00:00','计划已开始制定','昨晚放年假',1,1,NULL),
		       (14,1,'2019-02-03 09:00:00',1907,4,'胡新丰','13208695472','年前会议','14',1,1,4,'春节将至,各部门汇报本年度工作','2019-02-03 12:00:00',0,'2019-02-03 12:00:00','汇报完毕','早搞完早放假',1,1,'祝大家春节愉快'),
		       (15,2,'2019-02-12 09:00:00',1908,2,'刘志清','17928647513','新年致辞','15',1,1,4,'新的一年已经开始,董事长发表新年致辞','2019-02-12 12:00:00',0,'2019-02-12 12:00:00','人齐了',NULL,1,1,NULL);
		       


-- 最近更新页面
-- 	事项名称	 牵头部门		最新操作			操作时间   	操作人
SELECT r.item_name,r.org_id,o.org_name,i.sup_statu,i.org_statu,i.staff_statu,i.opt_time,u.`user_id`,u.`user_name` FROM repository r 
	LEFT JOIN item_process i 
	ON r.`id`=i.`item_code`
	LEFT JOIN organization o
	ON r.`org_id`=o.`org_id`
	LEFT JOIN `user` u 
	ON i.`user_id`=u.`user_id`;

-- 最近更新页面的更多
-- 	事项名称     操作时间
SELECT r.item_name,i.`opt_time` FROM repository r LEFT JOIN item_process i ON r.`item_code`=i.`item_code` ORDER BY i.`opt_time` DESC LIMIT 0,10;
	
	
	
-- 推进中的事项页面
-- 	事项名称	公司领导	牵头部门	  	负责人		    应办结时间	 下次反馈时间
SELECT r.`item_name`,u.`real_name`,r.`org_id`,o.`org_name`,r.`user_id`,i.`user_id`,r.`over_time`,next_feedback FROM repository r 
	LEFT JOIN item_process i 
	ON r.`id`=i.`item_code`
	LEFT JOIN `user` u 
	ON u.`user_id`=r.`user_id`
	LEFT JOIN organization o
	ON r.`org_id`=o.`org_id`;
	
-- 推进中事项页面的更多
-- 	  事项名称		批示领导			牵头部门	
SELECT r.`id`,r.`item_name`,r.`user_id`,u.`user_name`,o.`org_id`,o.`org_name` FROM repository r LEFT JOIN `user` u ON r.`user_id`=u.`user_id` LEFT JOIN organization o ON r.`org_id`=o.`org_id` LIMIT 0,10;



-- 查找任务类型以方便页面初始化
SELECT task_id,type_name FROM task_type;

-- 任务类型表
DROP TABLE IF EXISTS task_type;
CREATE TABLE task_type(
 task_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '任务类型id',
 type_name VARCHAR(100) NOT NULL COMMENT '任务类型名称',
 PRIMARY KEY(task_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO task_type(type_name) VALUES ('请指定事项负责人'),('请更新事项进展'),('请审批事项变更'),('请确定牵头部门、协办部门');


-- 用户表中添加部门账户
ALTER TABLE `supervise`.`user` CHANGE `edu_id` `edu_id` INT(11) NULL COMMENT '学历', CHANGE `duty_id` `duty_id` INT(11) NULL COMMENT '职务id'; 
INSERT INTO `user` (user_name,`password`,real_name,hiredate,org_id) VALUES ('mobilenet','mobilenet','移动互联网学院','2003-02-06',2);
INSERT INTO `user` (user_name,`password`,real_name,hiredate,org_id) VALUES 
		   ('numart','numart','数字艺术学院','2003-02-06',3),
		   ('develop','develop','开发部','2003-03-01',4),
		   ('education','education','教学部','2004-01-01',5);