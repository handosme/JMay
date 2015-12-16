package org.ihansen.jsmta.dao.interfaces;

import java.util.List;

/**
 * 通用的DAO
 * @author 吴帅
 * @CreationDate 2015年8月3日
 * @version 1.0
 */
public interface ICommonDAO <T,O,C>
{
	/**
	 * 根据条件查询记录条数，传入条件conditon为null时会抛出异常
	 * @author 吴帅
	 * @parameter @param conditon
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午9:51:29
	 */
	public int countByCondition(C conditon) throws Exception;
	
	/**
	 * 根据条件删除，传入条件conditon为null时会抛出异常
	 * @author 吴帅
	 * @parameter @param conditon
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午9:51:46
	 */
	public int deleteByCondition(C conditon) throws Exception;
	
	/**
	 * 根据主键删除
	 * @author 吴帅
	 * @parameter @param id
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午9:52:58
	 */
	public int deleteById(Long id) throws Exception;
	
	/**
	 * 新增
	 * @author 吴帅
	 * @parameter @param t
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午9:54:01
	 */
	public int add(T record) throws Exception;
	
	/**
	 * 根据条件查询，传入条件conditon为null时会抛出异常
	 * @author 吴帅
	 * @parameter @param conditon
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午9:54:19
	 */
	public List<T> queryByCondition(C conditon) throws Exception;
	
	/**
	 * 根据条件分页查询，传入条件conditon为null时会抛出异常
	 * @author 吴帅
	 * @parameter @param conditon
	 * @parameter @param start 其实位置，从0开始
	 * @parameter @param length 页长
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午9:55:06
	 */
	public List<T> queryByCondition(C conditon,int start,int length) throws Exception;
	
	/**
	 * 根据主键查询
	 * @author 吴帅
	 * @parameter @param id
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午9:56:38
	 */
	public T queryById(Long id) throws Exception;
	
	/**
	 * 根据条件更新，t中不为空的字段更新到符合条件记录的字段上
	 * @author 吴帅
	 * @parameter @param t
	 * @parameter @param conditon
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午9:59:46
	 */
	public int updateByCondition(T record,C conditon) throws Exception;
	
	/**
	 * 根据t中主键更新，record中不为空的字段更新到符合条件记录的字段上
	 * @author 吴帅
	 * @parameter @param t
	 * @parameter @param id
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午10:02:22
	 */
	public int updateById(T record) throws Exception;
	
	/**
	 * 批量插入
	 * @author 吴帅
	 * @parameter @param ts
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月3日 上午10:13:58
	 */
	public int add(List<T> records) throws Exception;
	
	/**
	 * 根据条件查询单个,传入条件conditon为null时会抛出异常
	 * @author 吴帅
	 * @parameter @param conditon
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年8月21日 下午3:02:07
	 */
	public T qrySingleByCondition(C conditon) throws Exception;
	
	/**
	 * 获取数据源连接名
	 * @author 吴帅
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年9月30日 上午10:32:06
	 */
	public String getDataSourceName() throws Exception;
}
