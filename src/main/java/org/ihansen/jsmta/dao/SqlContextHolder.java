package org.ihansen.jsmta.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.ihansen.jsmta.dao.interfaces.ICommonDAO;
import org.ihansen.jsmta.utils.Constant;

/**
 * 数据源持有者
 * @author 吴帅
 * @CreationDate 2015年11月10日
 * @version 1.0
 */
public class SqlContextHolder {

	private static transient Log log = LogFactory.getLog(SqlContextHolder.class);

	private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

	public static void setDataSourceKey(String dataSourceName) {
		log.debug("切换为数据源：" + dataSourceName);
		dataSourceKey.set(dataSourceName);
	}
	
	public static String getDatasourcekey() {
		return dataSourceKey.get();
	}

	public static void clearDataSourceKey() {
		log.debug("使用默认数据源");
		dataSourceKey.remove();
	}

	public Object setDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
		// 1.执行前处理
		ICommonDAO targetDao = (ICommonDAO) joinPoint.getTarget();
		if (targetDao.getDataSourceName() == null || targetDao.getDataSourceName().equals(Constant.DEFAULT_DATA_SOURCE) || targetDao.getDataSourceName().equals("null")) {
			clearDataSourceKey();
		}
		else {
			setDataSourceKey(targetDao.getDataSourceName());//切换数据源(事务中无效,此步可注释掉)
		}
		Object result = joinPoint.proceed();
		// 2.执行后处理
		
		return result;
	}
}
