USE supervise;

-- 学历表
DROP TABLE IF EXISTS education;
CREATE TABLE education(
 eid INT(11) NOT NULL AUTO_INCREMENT COMMENT '学历id',
 edu_name VARCHAR(30) NOT NULL COMMENT '学历名称',
 PRIMARY KEY(eid)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO education (edu_name) VALUES ('小学'),('初中'),('高中/中技/中专'),('大专'),('本科'),('硕士'),('博士');

-- 机构表
DROP TABLE IF EXISTS organization;
CREATE TABLE organization(
 org_id INT(11) NOT NULL  AUTO_INCREMENT COMMENT '机构id',
 org_name VARCHAR(200) NOT NULL COMMENT '机构名称',
 parent_orgid INT(11) COMMENT '父机构id',
 id_path VARCHAR(300) NOT NULL COMMENT '机构id路径',
 name_path VARCHAR(500) NOT NULL COMMENT '机构名称路径',
 introduction VARCHAR(1000) DEFAULT NULL COMMENT '机构简介',
 responsibility VARCHAR(1000) DEFAULT NULL COMMENT '机构职责',
 operation_date DATETIME DEFAULT NULL COMMENT '对该部门的操作日期',
 PRIMARY KEY(org_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO organization(org_name,id_path,name_path,introduction,responsibility,operation_date) VALUES ('牛耳教育','/1','/牛耳教育','牛耳教育是一所专业从事IT职业教育的机构，湖南省指定“服务外包人才培训基地”，在大连、南京等省市设有分部式实训基地。','培养IT人才','2001-01-01 12:00:00');
INSERT INTO organization(org_name,parent_orgid,id_path,name_path,introduction,responsibility,operation_date) VALUES ('移动互联网学院',1,'/1','/牛耳教育/移动互联网学院',NULL,'培训互联网人才','2001-03-01 12:00:00'),
													('数字艺术学院',1,'/1','/牛耳教育/数字艺术学院',NULL,NULL,'2001-03-01 12:00:00');
INSERT INTO organization(org_name,parent_orgid,id_path,name_path,introduction,responsibility,operation_date) VALUES ('开发部',2,'/1/2','/牛耳教育/移动互联网学院/开发部',NULL,'负责企业门户网站的开发','2001-06-01 12:00:00'),
													('教学部',3,'/1/3','/牛耳教育/数字艺术学院/教学部',NULL,'负责对学生的培养','2001-06-01 12:00:00');

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
 user_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
 user_name VARCHAR(100) NOT NULL COMMENT '登录用户名',
 `password` VARCHAR(20) NOT NULL COMMENT '密码',
 real_name VARCHAR(100) NOT NULL COMMENT '用户真实姓名',
 hiredate DATE NOT NULL COMMENT '入职日期',
 edu_id INT NOT NULL COMMENT '学历',
 org_id INT NOT NULL COMMENT '所在部门',
 duty_id INT NOT NULL COMMENT '职务id',
 opt_time DATETIME DEFAULT NULL,
 PRIMARY KEY(user_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `user`(user_name,`password`,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('zhangwei','zhang123','张伟','2001-01-01',7,1,1);
INSERT INTO `user`(user_name,`password`,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('liwei','li1234','李伟','2001-01-01',6,1,2);
INSERT INTO `user`(user_name,`password`,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('wangfang','wang123','王芳','2005-06-20',5,2,3);
INSERT INTO `user`(user_name,`password`,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('zhangdan','dan123','张单','2005-06-20',5,2,4);
INSERT INTO `user`(user_name,`password`,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('songmu','songmu123','宋睦','2005-06-20',5,3,3);
INSERT INTO `user`(user_name,`password`,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('songhe','songhe123','宋和','2005-06-20',5,3,4);
INSERT INTO `user`(user_name,`password`,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('liuwei','liu123','刘伟','2008-05-03',4,4,5);
INSERT INTO `user`(user_name,`password`,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('zhaoyao','zhao123','赵鹞','2008-05-03',4,5,5);




-- 职务表 duty
DROP TABLE IF EXISTS duty;
CREATE TABLE duty(
 duty_id INT NOT NULL AUTO_INCREMENT COMMENT '职务id',
 duty_name VARCHAR(100) NOT NULL COMMENT '职务名称',
 duty_type VARCHAR(100) NOT NULL COMMENT '职务类别',
 PRIMARY KEY(duty_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;
INSERT INTO duty(duty_name,duty_type) VALUES ('董事长','公司领导'),('CTO','公司领导'),('高经','部门主管'),('副高经','部门主管'),('普通员工','普通员工');



-- 督办来源表
DROP TABLE IF EXISTS source;
CREATE TABLE source(
  source_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '来源id',
  source_type VARCHAR(100) NOT NULL COMMENT '来源类型',
  PRIMARY KEY(source_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;
INSERT INTO source(source_type) VALUES ('领导批示'),('专题会议'),('签报领导意见表');



-- 附件表
DROP TABLE IF EXISTS attachment;
CREATE TABLE attachment(
 att_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '附件id',
 `name` VARCHAR(300) NOT NULL COMMENT '附件名称',
  path VARCHAR(1000) NOT NULL COMMENT '附件路径',
  item_code INT(11) NOT NULL COMMENT '事项id',
  opt_time DATETIME DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY(att_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;



-- 保密等级表
DROP TABLE IF EXISTS secrecy_level;
CREATE TABLE secrecy_level(
 level_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '等级id',
 level_name VARCHAR(50) NOT NULL,
 PRIMARY KEY(level_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;
INSERT INTO secrecy_level(level_name) VALUES ('绝密'),('机密'),('秘密'),('公开');


-- 文件类型表
DROP TABLE IF EXISTS file_type;
CREATE TABLE file_type(
 type_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
 type_name VARCHAR(100) NOT NULL,
 PRIMARY KEY(type_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;
INSERT INTO file_type(type_name) VALUES ('发文'),('收文'),('签报'),('白头文');



-- 备用库
DROP TABLE IF EXISTS repository;
CREATE TABLE repository (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '事项id',
  source_id int(11) NOT NULL COMMENT '督办来源',
  source_time datetime NOT NULL COMMENT '来源时间',
  serial_num varchar(100) NOT NULL COMMENT '原流水号',
  file_type int(11) NOT NULL COMMENT '文件类型id',
  drafter varchar(100) NOT NULL COMMENT '原件拟稿人',
  drafter_phone char(11) NOT NULL COMMENT '拟稿人联系电话',
  item_name varchar(250) NOT NULL COMMENT '事项名称',
  item_code varchar(50) NOT NULL COMMENT '事项编号',
  user_id int(11) NOT NULL COMMENT '(批示的)公司领导',
  adverse_company varchar(250) NOT NULL COMMENT '对方单位',
  secrecy_level int(11) NOT NULL COMMENT '保密等级',
  item_content varchar(2000) NOT NULL COMMENT '事项内容',
  over_time datetime DEFAULT NULL COMMENT '结束时间',
  feedback int(11) DEFAULT NULL COMMENT '反馈频率',
  next_feedback datetime DEFAULT NULL COMMENT '下次反馈时间',
  dept_opinion varchar(2000) DEFAULT NULL COMMENT '部门意见',
  lead_opinion varchar(2000) DEFAULT NULL COMMENT '领导批示',
  item_statu int(11) DEFAULT '0' COMMENT '事项状态 0 删除 1未删除',
  item_type  int(11) DEFAULT '0' COMMENT '事项类型 0 新增  1同步 2退回',
  remark varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
INSERT INTO repository (source_id,source_time,serial_num,file_type,drafter,drafter_phone,item_name,item_code,user_id,adverse_company,secrecy_level,item_content,over_time,feedback,next_feedback,dept_opinion,lead_opinion,item_statu,item_type,remark)  
VALUES(2,'2019-03-20 12:06:13',2222,2,'小三',123456789,'中秋晚会',1002,2,'文艺部',2,'筹备文艺晚会','2019-03-24 11:12:12',2,'2019-03-21 14:12:30','不通过','',0,1,'')


-- 事项进展表
DROP TABLE IF EXISTS item_process;
CREATE TABLE item_process(
  statu_id INT NOT NULL AUTO_INCREMENT COMMENT '状态id',
  item_code VARCHAR(50) NOT NULL COMMENT '事项id',
  statu_describe VARCHAR(100)  COMMENT '状态描述',
  opt_time DATETIME NOT NULL COMMENT '操作时间',
  user_id INT(11) NOT NULL COMMENT '操作人',
  PRIMARY KEY(statu_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;
INSERT INTO item_process (item_code,statu_describe,opt_time,user_id) VALUES(1002,'','2019-03-21 12:10:49',2)

