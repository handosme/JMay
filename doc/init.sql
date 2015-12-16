
/*************************************************************************/
/*主键维护表*/
drop table if exists `sys_sequence_id`;
create table `sys_sequence_id`(
	`seq_post_id` bigint(15) NOT NULL primary key AUTO_INCREMENT COMMENT '主键'
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*MyISAM引擎不支持事务*/show engines;
/*可修改为支持事务的InnoDB引擎*/alter table `sys_sequence_id` ENGINE = InnoDB;

/*访问者记录表*/
drop table if exists `bus_visit_record`;
create table `bus_visit_record`(
	`id` bigint(15) NOT NULL primary key AUTO_INCREMENT COMMENT '主键',
	`user_id` varchar(128) COMMENT '用户编号',
	`ip` varchar(256) COMMENT '访问者ip',
	`posit` varchar(256) COMMENT '访问者所在位置经纬度',
	`visit_date` datetime COMMENT '访问时间',
	`remark` varchar(256) COMMENT '备注',
	index `index_1` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='访问者记录表';
/*MyISAM引擎不支持事务*/show engines;
/*可修改为支持事务的InnoDB引擎*/alter table `bus_visit_record` ENGINE = InnoDB;


drop table if exists `bus_user_info`;
create table `bus_user_info`(
	`id` bigint(15) NOT NULL primary key AUTO_INCREMENT COMMENT '主键',
	`user_id` varchar(20) COMMENT '用户编号',
	`user_type` varchar(2) COMMENT '用户类别',
	`user_agent` varchar(256) COMMENT '访问者使用的浏览器',
	`create_date` datetime COMMENT '创建时间',
	`done_date` datetime COMMENT '更新时间',
	`remark` varchar(256) COMMENT '备注',
	index `index_1` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
/*MyISAM引擎不支持事务*/show engines;
/*可修改为支持事务的InnoDB引擎*/alter table `bus_user_info` ENGINE = InnoDB;

drop table if exists `bus_user_relation`;
create table `bus_user_relation`(
	`id` bigint(15) NOT NULL primary key AUTO_INCREMENT COMMENT '主键',
	`user_id` varchar(20) COMMENT '用户编号',
	`f_user_id` varchar(20) COMMENT '推荐用户编号',
	`create_date` datetime COMMENT '创建时间',
	`done_date` datetime COMMENT '更新时间',
	`remark` varchar(256) COMMENT '备注',
	index `index_1` (`user_id`),
	index `index_2` (`f_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='用户关系表';
/*MyISAM引擎不支持事务*/show engines;
/*可修改为支持事务的InnoDB引擎*/alter table `bus_user_relation` ENGINE = InnoDB;

drop table if exists `bus_search_record`;
create table `bus_search_record`(
	`id` bigint(15) NOT NULL primary key AUTO_INCREMENT COMMENT '主键',
	`user_id` varchar(20) COMMENT '用户编号',
	`name` varchar(20) COMMENT '姓名',
	`rela_type` varchar(2) COMMENT '用户和姓名关系:1本人，2朋友，3陌生人',
	`create_date` datetime COMMENT '创建时间',
	`done_date` datetime COMMENT '更新时间',
	`remark` varchar(256) COMMENT '备注',
	index `index_1` (`user_id`),
	index `index_2` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='查询记录表';
/*MyISAM引擎不支持事务*/show engines;
/*可修改为支持事务的InnoDB引擎*/alter table `bus_search_record` ENGINE = InnoDB;


drop table if exists `bus_name_info`;
create table `bus_name_info`(
	`id` bigint(18) NOT NULL primary key AUTO_INCREMENT COMMENT '主键',
	`name` varchar(20) COMMENT '姓名',
	`total` bigint(15) COMMENT '总数',
	`areaid_0` bigint(12) COMMENT '',
	`areaid_1` bigint(12) COMMENT '',
	`areaid_2` bigint(12) COMMENT '',
	`areaid_3` bigint(12) COMMENT '',
	`areaid_4` bigint(12) COMMENT '',
	`areaid_5` bigint(12) COMMENT '',
	`areaid_6` bigint(12) COMMENT '',
	`areaid_7` bigint(12) COMMENT '',
	`areaid_8` bigint(12) COMMENT '',
	`areaid_9` bigint(12) COMMENT '',
	`areaid_10` bigint(12) COMMENT '',
	`areaid_11` bigint(12) COMMENT '',
	`areaid_12` bigint(12) COMMENT '',
	`areaid_13` bigint(12) COMMENT '',
	`areaid_14` bigint(12) COMMENT '',
	`areaid_15` bigint(12) COMMENT '',
	`areaid_16` bigint(12) COMMENT '',
	`areaid_17` bigint(12) COMMENT '',
	`areaid_18` bigint(12) COMMENT '',
	`areaid_19` bigint(12) COMMENT '',
	`areaid_20` bigint(12) COMMENT '',
	`areaid_21` bigint(12) COMMENT '',
	`areaid_22` bigint(12) COMMENT '',
	`areaid_23` bigint(12) COMMENT '',
	`areaid_24` bigint(12) COMMENT '',
	`areaid_25` bigint(12) COMMENT '',
	`areaid_26` bigint(12) COMMENT '',
	`areaid_27` bigint(12) COMMENT '',
	`areaid_28` bigint(12) COMMENT '',
	`areaid_29` bigint(12) COMMENT '',
	`areaid_30` bigint(12) COMMENT '',
	`areaid_31` bigint(12) COMMENT '',
	`areaid_32` bigint(12) COMMENT '',
	`areaid_33` bigint(12) COMMENT '',
	`areaid_34` bigint(12) COMMENT '',
	`areaid_35` bigint(12) COMMENT '其他',
	`create_date` datetime COMMENT '创建时间',
	`done_date` datetime COMMENT '更新时间',
	`remark` varchar(256) COMMENT '备注',
	index `index_1` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='姓名信息表';
/*MyISAM引擎不支持事务*/show engines;
/*可修改为支持事务的InnoDB引擎*/alter table `bus_name_info` ENGINE = InnoDB;

drop table if exists `bus_feedback_record`;
create table `bus_feedback_record`(
	`id` bigint(15) NOT NULL primary key AUTO_INCREMENT COMMENT '主键',
	`user_id` varchar(20) COMMENT '用户编号',
	`feed_type` varchar(2) COMMENT '反馈类型:1.查询结果错误反馈；2.优化意见建议',
	`feedback` varchar(2048) COMMENT '反馈内容',
	`create_date` datetime COMMENT '创建时间',
	`remark` varchar(256) COMMENT '备注',
	index `index_1` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='反馈记录表';
/*MyISAM引擎不支持事务*/show engines;
/*可修改为支持事务的InnoDB引擎*/alter table `bus_feedback_record` ENGINE = InnoDB;











