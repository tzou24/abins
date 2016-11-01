/**
 * @description 使用mysql
 * @date 2016-09-27 
 * @author yaobin
 */
--创建数据库
CREATE DATABASE abins;
use abins;

/**
 * 用户登录表
 */
DROP TABLE IF EXISTS a_base_user;
create table a_base_user(
	base_user_id varchar(36) NOT NULL comment '主键ID',
	login_account varchar(50) NOT NULL comment '登录账号',
	email varchar(30) NOT NULL comment '邮箱',
	login_password varchar(50) NOT NULL comment '登录密码',
	login_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '登录时间',
	PRIMARY KEY (base_user_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='用户登录表';

--插入超级管理员数据
INSERT INTO a_base_user values('4028b29557ac49f40157ac49f45f0000', 'admin', 'm15080331543@163.com', '2190F85C07346F670A09E05C6C499C04', now());


/**
 * 角色表
 */
DROP TABLE IF EXISTS a_role;
CREATE TABLE a_role(
	role_id varchar(36) NOT NULL comment '角色主键',
	role_name varchar(50) NOT NULL comment '角色名称',
	create_time timestamp NOT NULL default CURRENT_TIMESTAMP comment '创建时间',
	creator varchar(36) NOT NULL comment '创建者',
	update_time timestamp NOT NULL comment '修改时间',
	PRIMARY KEY (role_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='角色表';

--插入超级管理员角色
INSERT INTO a_role values('4028b29557ac779a0157ac779a9a0000', '超级管理员', now(), '4028b29557ac49f40157ac49f45f0000', now());

/**
 * 用户角色关系表
 */
DROP TABLE IF EXISTS a_user_role;
CREATE TABLE a_user_role(
	user_role_id varchar(36) NOT NULL comment '用户角色关系主键',
	base_user_id varchar(36) NOT NULL comment '用户主键',
	role_id varchar(36) NOT NULL comment '角色主键',
	PRIMARY KEY (user_role_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='用户角色关系表';

INSERT INTO a_user_role values('4028b29557ad1c3f0157ad1c3f370000', '4028b29557ac49f40157ac49f45f0000', '4028b29557ac779a0157ac779a9a0000');

/**
 * 资源权限表
 */
DROP TABLE IF EXISTS a_permission;
CREATE TABLE a_permission(
	permission_id varchar(36) NOT NULL comment '资源权限主键',
	name varchar(50) NOT NULL comment '资源权限名称',
	url varchar(50) NOT NULL comment '资源地址',
	`order` int(5) default 1 comment '资源排序值',
	parent_id varchar(36) NOT NULL comment '父级主键',
	header_html varchar(500) NOT NULL comment '导航头标签',
	PRIMARY KEY(permission_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='资源权限表';

INSERT INTO a_permission values('4028b29557ad1da40157ad1da45d0000', '主页', '/platform/main/home', 10, '4028b29557ad1da40157ad1da45d0000', '<p>主页</p>');

/**
 * 资源权限与角色关系表
 */
DROP TABLE IF EXISTS a_role_permission;
CREATE TABLE a_role_permission(
	role_permission_id varchar(36) NOT NULL comment '主键',
	permission_id varchar(36) NOT NULL comment '资源权限主键',
	role_id varchar(36) NOT NULL comment '角色主键',
	PRIMARY KEY(role_permission_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='资源权限与角色关系表';

INSERT INTO a_role_permission values('4028b29557ad25300157ad2530420000', '4028b29557ad1da40157ad1da45d0000', '4028b29557ac779a0157ac779a9a0000');

/**
 * 组织机构表
 */ 
DROP TABLE IF EXISTS a_org;
CREATE TABLE a_org(
	org_id varchar(36) NOT NULL comment '主键',
	name varchar(50) NOT NULL comment '组织名称',
	description varchar(255) comment '组织描述',
	parent_org_id varchar(36) NOT NULL comment '父级组织',
	PRIMARY KEY(org_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='组织机构表';


/**
 * 组织用户关联表
 */
DROP TABLE IF EXISTS a_user_org;
CREATE TABLE a_user_org(
	user_org_id varchar(36) NOT NULL comment '组织用户主键',
	org_id varchar(36) NOT NULL comment '组织机构主键',
	user_id varchar(36) NOT NULL comment '用户主键',
	PRIMARY KEY(user_org_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='组织用户关联表';

/**
 * 系统字典表 
 */
DROP TABLE IF EXISTS a_dict;
CREATE TABLE a_dict(
	dict_id varchar(36) NOT NULL comment '字典主键',
	dict_type varchar(50) NOT NULL comment '字典类别',
	code varchar(50) NOT NULL comment '字典编码', 
	PRIMARY KEY(dict_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='字典表';

/**
 * 字典数据表
 */
DROP TABLE IF EXISTS a_dict_type;
CREATE TABLE a_dict_type(
	dict_type_id varchar(36) NOT NULL comment '字典数据主键',
	type_name varchar(100) NOT NULL comment '字典名称',
	type_value varchar(100) NOT NULL comment '字典值',
	dict_id varchar(36) NOT NULL comment '字典表ID',
	PRIMARY KEY(dict_type_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='字典数据表';
