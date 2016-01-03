package org.ihansen.jsmta.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource
{
	private static transient Log log = LogFactory.getLog(DynamicDataSource.class);

	/**
	 * 在事务中不会调用,在事务重要实现数据源动态切换需要为每个数据源实现一个sqlSessionFactory
	 */
	@Override
	protected Object determineCurrentLookupKey()
	{
		String lookUpKey = SqlContextHolder.getDatasourcekey();
		log.info("--------->>>>使用数据源："+lookUpKey);
		return lookUpKey;
	}

}
