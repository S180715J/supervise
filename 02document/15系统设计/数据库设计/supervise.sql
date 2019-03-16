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
 real_name VARCHAR(100) NOT NULL COMMENT '用户真实姓名',
 hiredate DATE NOT NULL COMMENT '入职日期',
 edu_id INT NOT NULL COMMENT '学历',
 org_id INT NOT NULL COMMENT '所在部门',
 duty_id INT NOT NULL COMMENT '职务id',
 opt_time DATETIME DEFAULT NULL,
 PRIMARY KEY(user_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `user`(user_name,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('zhangwei','张伟','2001-01-01',7,1,1);
INSERT INTO `user`(user_name,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('liwei','李伟','2001-01-01',6,1,2);
INSERT INTO `user`(user_name,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('wangfang','王芳','2005-06-20',5,2,3);
INSERT INTO `user`(user_name,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('zhangdan','张单','2005-06-20',5,2,4);
INSERT INTO `user`(user_name,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('songmu','宋睦','2005-06-20',5,3,3);
INSERT INTO `user`(user_name,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('songhe','宋和','2005-06-20',5,3,4);
INSERT INTO `user`(user_name,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('liuwei','刘伟','2008-05-03',4,4,5);
INSERT INTO `user`(user_name,real_name,hiredate,edu_id,org_id,duty_id) VALUES ('zhaoyao','赵鹞','2008-05-03',4,5,5);



-- 职务表 duty
DROP TABLE IF EXISTS duty;
CREATE TABLE duty(
 duty_id INT NOT NULL AUTO_INCREMENT COMMENT '职务id',
 duty_name VARCHAR(100) NOT NULL COMMENT '职务名称',
 duty_type VARCHAR(100) NOT NULL COMMENT '职务类别',
 PRIMARY KEY(duty_id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;
INSERT INTO duty(duty_name,duty_type) VALUES ('董事长','公司领导'),('CTO','公司领导'),('高经','部门主管'),('副高经','部门主管'),('普通员工','普通员工');





