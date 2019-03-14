/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/3/12 17:58:11                           */
/*==============================================================*/


drop table if exists ATTACHMENT;

drop table if exists DICT;

drop table if exists ITEM_CHANGE;

drop table if exists ITEM_LEADER;

drop table if exists ITEM_ORG;

drop table if exists ITEM_PROCESS;

drop table if exists ITEM_REPOSITORY;

drop table if exists ORGANICATION;

drop table if exists USER;

/*==============================================================*/
/* Table: ATTACHMENT                                            */
/*==============================================================*/
create table ATTACHMENT
(
   ID                   bigint not null auto_increment,
   NAME                 varchar(300),
   PATH                 varchar(1000),
   ITEM_CODE            varchar(20),
   OPT_TIME             datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: DICT                                                  */
/*==============================================================*/
create table DICT
(
   TYPE                 varchar(20),
   TYPE_ID              varchar(20),
   TYPE_NAME            varchar(100),
   "DESC"               varchar(250),
   OPT_TIME             datetime,
   "ORDER"              integer
);

/*==============================================================*/
/* Table: ITEM_CHANGE                                           */
/*==============================================================*/
create table ITEM_CHANGE
(
   ITEM_CODE            varchar(20),
   ITEM_DETAIL          varchar(300),
   ITEM_TIME            datetime
);

/*==============================================================*/
/* Table: ITEM_LEADER                                           */
/*==============================================================*/
create table ITEM_LEADER
(
   ITEM_CODE            varchar(50),
   USERID               bigint
);

/*==============================================================*/
/* Table: ITEM_ORG                                              */
/*==============================================================*/
create table ITEM_ORG
(
   ITEM_CODE            varchar(50),
   ORGID                bigint,
   USERID               bigint,
   ISPRIMARY            char(1) comment '1��,0��'
);

/*==============================================================*/
/* Table: ITEM_PROCESS                                          */
/*==============================================================*/
create table ITEM_PROCESS
(
   ITEM_CODE            varchar(20),
   ITEM_STATUS          varchar(2) comment '��������->�쵼ָ��ǩͷ����->����ָ��������->�����˸��������չ->�����˺Ÿ��������չ->����Ա�������������Ϣ->����Ա�����ʾ������У�->����',
   ITEM_STATUS_DESC     varchar(30),
   OPT_TIME             datetime,
   USER_ID              bigint
);

/*==============================================================*/
/* Table: ITEM_REPOSITORY                                       */
/*==============================================================*/
create table ITEM_REPOSITORY
(
   ID                   bigint not null auto_increment,
   SOURCE               varchar(300),
   SOURCE_TIME          datetime,
   SERIAL_NUM           varchar(100),
   FILE_TYPE            varchar(2) comment '�������ֵ��ȡ
            ���ġ����ġ�ǩ������ͷ�ġ�����',
   DRAFTER              varchar(100),
   DRAFTER_TEL          varchar(30),
   ITEM_NAME            varchar(250),
   ITEM_CODE            varchar(50),
   ADVERSE_COMPANY      varchar(250),
   SECRITY              char(1) comment '�������ֵ�������ܡ�����һ�������ܶ����������������ڲ���Ϣ',
   ITEM_CONTENT         varchar(2000),
   OVER_TIME            datetime,
   CALL_BACK            char(1) comment 'ÿ�ܡ�ÿ˫�ܡ�ÿ�¡�ÿ2���¡�ÿ���ȡ�ÿ����',
   NEXT_CALLTIME        datetime,
   ITEM_DEPT_IDEA       varchar(2000),
   LEADER_IDEA          varchar(2000),
   ITEM_STATUS          varchar(2),
   REMARK               varchar(2000),
   primary key (ID)
);

/*==============================================================*/
/* Table: ORGANICATION                                          */
/*==============================================================*/
create table ORGANICATION
(
   ORGID                bigint not null auto_increment,
   ORGCODE              varchar(20),
   ORGNAME              varchar(200),
   PARENT_ORGID         bigint,
   IDPATH               varchar(300),
   NAMEPATH             varchar(500),
   INTRO                varchar(1000),
   JOB                  varchar(1000),
   OPT_TIME             datetime,
   "ORDER"              int,
   primary key (ORGID)
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   USERID               bigint not null auto_increment,
   USERNAME             varchar(100),
   REALNAME             varchar(250),
   HIREDATE             datetime,
   EDU                  char(1),
   GENDER               char(1),
   ORGID                bigint,
   JOB                  char(2),
   JOBTYPE              char(2),
   OPT_TIME             datetime,
   primary key (USERID)
);

