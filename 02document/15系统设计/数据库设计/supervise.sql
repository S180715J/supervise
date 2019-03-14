
/*数据库名supervise
基字符集  utf8
数据库排序规则utfu_general_ci*/

DROP TABLE IF EXISTS ATTACHMENT;

DROP TABLE IF EXISTS DICT;

DROP TABLE IF EXISTS ITEM_CHANGE;

DROP TABLE IF EXISTS ITEM_LEADER;

DROP TABLE IF EXISTS ITEM_ORG;

DROP TABLE IF EXISTS ITEM_PROCESS;

DROP TABLE IF EXISTS ITEM_REPOSITORY;

DROP TABLE IF EXISTS ORGANICATION;

DROP TABLE IF EXISTS USER;

/*==============================================================*/
/* Table: ATTACHMENT                                            */
/*==============================================================*/
CREATE TABLE ATTACHMENT
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   NAME                 VARCHAR(300),
   PATH                 VARCHAR(1000),
   ITEM_CODE            VARCHAR(20),
   OPT_TIME             DATETIME,
   PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: DICT                                                  */
/*==============================================================*/
CREATE TABLE DICT
(
   `TYPE`                 VARCHAR(20),
   TYPE_ID              VARCHAR(20),
   TYPE_NAME            VARCHAR(100),
   `DESC`               VARCHAR(250),
   OPT_TIME             DATETIME,
   `ORDER`              INT
);

/*==============================================================*/
/* Table: ITEM_CHANGE                                           */
/*==============================================================*/
CREATE TABLE ITEM_CHANGE
(
   ITEM_CODE            VARCHAR(20),
   ITEM_DETAIL          VARCHAR(300),
   ITEM_TIME            DATETIME
);

/*==============================================================*/
/* Table: ITEM_LEADER                                           */
/*==============================================================*/
CREATE TABLE ITEM_LEADER
(
   ITEM_CODE            VARCHAR(50),
   USERID               BIGINT
);

/*==============================================================*/
/* Table: ITEM_ORG                                              */
/*==============================================================*/
CREATE TABLE ITEM_ORG
(
   ITEM_CODE            VARCHAR(50),
   ORGID                BIGINT,
   USERID               BIGINT,
   ISPRIMARY            CHAR(1) COMMENT '1是,0否'
);

/*==============================================================*/
/* Table: ITEM_PROCESS                                          */
/*==============================================================*/
CREATE TABLE ITEM_PROCESS
(
   ITEM_CODE            VARCHAR(20),
   ITEM_STATUS          VARCHAR(2) COMMENT '督办立项->领导指定签头部门->部门指定负责人->负责人

更新事项进展->部门账号更新事项进展->督办员更新事项基本信息->督办员添加批示（如果有）->结束',
   ITEM_STATUS_DESC     VARCHAR(30),
   OPT_TIME             DATETIME,
   USER_ID              BIGINT
);

/*==============================================================*/
/* Table: ITEM_REPOSITORY                                       */
/*==============================================================*/
CREATE TABLE ITEM_REPOSITORY
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   SOURCE               VARCHAR(300),
   SOURCE_TIME          DATETIME,
   SERIAL_NUM           VARCHAR(100),
   FILE_TYPE            VARCHAR(2) COMMENT '从数据字典读取
            收文、发文、签报、白头文、其他',
   DRAFTER              VARCHAR(100),
   DRAFTER_TEL          VARCHAR(30),
   ITEM_NAME            VARCHAR(250),
   ITEM_CODE            VARCHAR(50),
   ADVERSE_COMPANY      VARCHAR(250),
   SECRITY              CHAR(1) COMMENT '从数据字典读：机密、商密一级、商密二级、商密三级、内

部信息',
   ITEM_CONTENT         VARCHAR(2000),
   OVER_TIME            DATETIME,
   CALL_BACK            CHAR(1) COMMENT '每周、每双周、每月、每2个月、每季度、每半年',
   NEXT_CALLTIME        DATETIME,
   ITEM_DEPT_IDEA       VARCHAR(2000),
   LEADER_IDEA          VARCHAR(2000),
   ITEM_STATUS          VARCHAR(2),
   REMARK               VARCHAR(2000),
   PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: ORGANICATION                                          */
/*==============================================================*/
CREATE TABLE ORGANICATION
(
   ORGID                BIGINT NOT NULL AUTO_INCREMENT,
   ORGCODE              VARCHAR(20),
   ORGNAME              VARCHAR(200),
   PARENT_ORGID         BIGINT,
   IDPATH               VARCHAR(300),
   NAMEPATH             VARCHAR(500),
   INTRO                VARCHAR(1000),
   JOB                  VARCHAR(1000),
   OPT_TIME             DATETIME,
   `ORDER`             INT,
   PRIMARY KEY (ORGID)
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
CREATE TABLE USER
(
   USERID               BIGINT NOT NULL AUTO_INCREMENT,
   USERNAME             VARCHAR(100),
   REALNAME             VARCHAR(250),
   HIREDATE             DATETIME,
   EDU                  CHAR(1),
   GENDER               CHAR(1),
   ORGID                BIGINT,
   JOB                  CHAR(2),
   JOBTYPE              CHAR(2),
   OPT_TIME             DATETIME,
   PRIMARY KEY (USERID)
);