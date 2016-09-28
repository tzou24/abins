/**
 * @description 数据库使用mysql
 * @date 2016-09-27 
 * @author yaobin
 */
--初始化数据库
CREATE DATABASE abins;
use abins;

/**
 * 基础登录用户表
 */
DROP TABLE IF EXISTS a_base_user;
create table a_base_user(
	base_user_id varchar(36) NOT NULL comment '登录用户主键',
	login_account varchar(50) NOT NULL comment '登录账号',
	email varchar(30) NOT NULL comment '邮箱地址',
	login_password varchar(50) NOT NULL comment '登录密码',
	login_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '最后登录时间',
	PRIMARY KEY (base_user_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='基础用户表';

--超级用户增加
INSERT INTO a_base_user values('123dsadasdas', 'admin', 'admin@163.com', '2190F85C07346F670A09E05C6C499C04', now());