package org.ihansen.jsmta.dao.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ihansen.jsmta.dao.interfaces.ICommonDAO;
import org.ihansen.jsmta.utils.Constant;
import org.ihansen.mbtgen.extend.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class CommonDAOImpl<T, O, C> implements ICommonDAO<T, O, C>
{
	private static transient Log log = LogFactory.getLog(CommonDAOImpl.class);
	
	public final static String COUNT_BY_EXAMPLE = "countByExample";
	public final static String DELETE_BY_EXAMPLE = "deleteByExample";
	public final static String DELETE_BY_PRIMARYKEY = "deleteByPrimaryKey";
	public final static String INSERT_SELECTIVE = "insertSelective";
	public final static String SELECT_BY_EXAMPLE = "selectByExample";
	public final static String SET_PAGEHELPER = "setPageHelper";
	public final static String SELECT_BY_PRIMARYKEY = "selectByPrimaryKey";
	public final static String UPDATE_BY_EXAMPLE_SELECTIVE = "updateByExampleSelective";
	public final static String UPDATE_BY_PRIMARYKEY_SELECTIVE = "updateByPrimaryKeySelective";
	public final static String INSERT_BATCH = "insertBatch";
	
	
	
	@Autowired
	private O operate;
	
	@Override
	public int countByCondition(C conditon) throws Exception
	{
		int returnValue = 0;
		if(conditon != null)
		{
			Method method = operate.getClass().getMethod(COUNT_BY_EXAMPLE, conditon.getClass());
			returnValue = (int) method.invoke(operate, conditon);
		}
		else
		{
			throw new Exception("查询条件为null");
		}
		return returnValue;
	}

	@Override
	public int deleteByCondition(C conditon) throws Exception
	{
		int returnValue = 0;
		if(conditon != null)
		{
			Method method = operate.getClass().getMethod(DELETE_BY_EXAMPLE, conditon.getClass());
			returnValue = (int) method.invoke(operate, conditon);
		}
		else
		{
			throw new Exception("删除条件为null");
		}
		return returnValue;
	}

	@Override
	public int deleteById(Long id) throws Exception
	{
		int returnValue = 0;
		if(id !=null)
		{
			Method method = operate.getClass().getMethod(DELETE_BY_PRIMARYKEY, id.getClass());
			returnValue = (int) method.invoke(operate, id);
		}
		return returnValue;
		
	}

	@Override
	public int add(T record) throws Exception
	{
		int returnValue = 0;
		if(record != null)
		{
			Method method = operate.getClass().getMethod(INSERT_SELECTIVE, record.getClass());
			returnValue = (int) method.invoke(operate, record);
		}
		return returnValue;
	}

	@Override
	public List<T> queryByCondition(C conditon) throws Exception
	{
		List<T> results = new ArrayList<T>();
		if(conditon !=null)
		{
			Method method = operate.getClass().getMethod(SELECT_BY_EXAMPLE, conditon.getClass());
			results = (List<T>) method.invoke(operate, conditon);
		}
		else
		{
			throw new Exception("查询条件为null");
		}
		return results;
	}

	@Override
	public List<T> queryByCondition(C conditon, int start, int length) throws Exception
	{
		List<T> results = new ArrayList<T>();
		if(conditon != null)
		{
			try
			{
				if(start>=0 && length>=0)
				{
					PageHelper pageHelper = new PageHelper(start,length);
					conditon.getClass().getMethod(SET_PAGEHELPER, PageHelper.class).invoke(conditon, pageHelper);
				}
				Method operateMethod = operate.getClass().getMethod(SELECT_BY_EXAMPLE, conditon.getClass());
				results = (List<T>) operateMethod.invoke(operate, conditon);
			}
			catch (Exception e)
			{
				log.error(e, e);
				throw e;
			}
		}
		else
		{
			throw new RuntimeException("查询条件为null");
		}
		return results;
	}

	@Override
	public T queryById(Long id) throws Exception
	{
		T record = null;
		if(id !=null)
		{
			Method method = operate.getClass().getMethod(SELECT_BY_PRIMARYKEY, id.getClass());
			record = (T) method.invoke(operate, id);
		}
		return record;
	}

	@Override
	public int updateByCondition(T record, C conditon) throws Exception
	{
		int returnValue = 0;
		if(record != null && conditon !=null)
		{
			Method method = operate.getClass().getMethod(UPDATE_BY_EXAMPLE_SELECTIVE, record.getClass(), conditon.getClass());
			returnValue = (int) method.invoke(operate, record, conditon);
		}
		return returnValue;
		
	}

	@Override
	public int updateById(T record) throws Exception
	{
		int returnValue = 0;
		if(record != null)
		{
			Method method = operate.getClass().getMethod(UPDATE_BY_PRIMARYKEY_SELECTIVE, record.getClass());
			returnValue = (int) method.invoke(operate, record);
		}
		return returnValue;
		
	}

	@Override
	public int add(List<T> records) throws Exception
	{
		int returnValue = 0;
		if(records != null && records.size()>0)
		{
			Method method = operate.getClass().getMethod(INSERT_BATCH, List.class);
			returnValue = (int) method.invoke(operate, records);
		}
		return returnValue;
	}

	@Override
	public T qrySingleByCondition(C conditon) throws Exception
	{
		T t=null;
		List<T> ts = queryByCondition(conditon);
		if(ts!=null && ts.size()>0)
		{
			t = ts.get(0);
		}
		return t;
	}

	@Override
	public String getDataSourceName() throws Exception
	{
		return (String) operate.getClass().getField(Constant.DATA_SOURCE_NAME).get(operate);
	}
	
}
