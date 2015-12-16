
/***********数据源db1,oracle**************************************************************/

/*编号生成器依赖的序列*/
create sequence WYPAY.BUS_NO_SEQUENCE
minvalue 1000000
maxvalue 999999999
start with 1000000
increment by 1
order;

/*>>用户授权表,begin*/
create table WYPAY.USER_AUTH
(
  ID                	NUMBER(15) not null primary key,
  USER_ID       		VARCHAR2(20),
  AUTH_NAME         	VARCHAR2(25),
  AUTH_ID       		VARCHAR2(20),
  AUTH_ACCESS_TOKEN 	VARCHAR2(128),
  AUTH_EXPIRES   		NUMBER(15),
  CREATE_DATE       	DATE,
  DONE_DATE         	DATE,
  STATE             	CHAR(1),
  REMARK           		VARCHAR2(256)
);
-- Add comments to the columns 
comment on column WYPAY.USER_AUTH.ID  is '主键';
comment on column WYPAY.USER_AUTH.USER_ID  is '用户编号';
comment on column WYPAY.USER_AUTH.AUTH_NAME  is '授权名称：loacl,weibo,qq';
comment on column WYPAY.USER_AUTH.AUTH_ID  is '授权编号';
comment on column WYPAY.USER_AUTH.AUTH_ACCESS_TOKEN  is '授权令牌';
comment on column WYPAY.USER_AUTH.AUTH_EXPIRES  is '授权有效时长,单位：毫秒';
comment on column WYPAY.USER_AUTH.CREATE_DATE is '创建时间';
comment on column WYPAY.USER_AUTH.DONE_DATE is '操作时间';
comment on column WYPAY.USER_AUTH.STATE is '状态';
comment on column WYPAY.USER_AUTH.REMARK is '备注';
-- Create sequence 
create sequence WYPAY.USER_AUTH_SEQUENCE
minvalue 100000
maxvalue 999999999
start with 100000
increment by 1
order;
/*<<用户授权表,end*/


