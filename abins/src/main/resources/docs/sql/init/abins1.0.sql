/**
 * @description ���ݿ�ʹ��mysql
 * @date 2016-09-27 
 * @author yaobin
 */
--��ʼ�����ݿ�
CREATE DATABASE abins;
use abins;

/**
 * ������¼�û���
 */
DROP TABLE IF EXISTS a_base_user;
create table a_base_user(
	base_user_id varchar(36) NOT NULL comment '��¼�û�����',
	login_account varchar(50) NOT NULL comment '��¼�˺�',
	email varchar(30) NOT NULL comment '�����ַ',
	login_password varchar(50) NOT NULL comment '��¼����',
	login_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '����¼ʱ��',
	PRIMARY KEY (base_user_id)
)ENGINE=InnoDB default CHARSET=utf8 comment='�����û���';

--�����û�����
INSERT INTO a_base_user values('123dsadasdas', 'admin', 'admin@163.com', '2190F85C07346F670A09E05C6C499C04', now());