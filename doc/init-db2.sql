
/***********数据源db2,mysql**************************************************************/
/*主键维护表*/
drop table if exists `sys_sequence_id`;
create table `sys_sequence_id`(
	`seq_post_id` bigint(15) NOT NULL primary key AUTO_INCREMENT COMMENT '主键'
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*MyISAM引擎不支持事务*/show engines;
/*可修改为支持事务的InnoDB引擎*/alter table `sys_sequence_id` ENGINE = InnoDB;

/*业务记录表*/
drop table if exists `bus_log`;
create table `bus_log`(
	`id` bigint(15) NOT NULL primary key AUTO_INCREMENT COMMENT '主键',
	`bus_id` varchar(30) NOT NULL COMMENT '业务编号',
	`operator_id` varchar(30) NOT NULL COMMENT '操作员编号',
	`content` varchar(256) COMMENT '详细内容',
	`done_date` datetime NOT NULL COMMENT '操作时间',
	`result` varchar(1) NOT NULL COMMENT '操作结果:S成功,F失败,P处理中',
	`state` varchar(1) NOT NULL COMMENT '记录状态:U有效,E失效',
	`remark` varchar(256) COMMENT '备注'
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='业务记录表';





