package org.ihansen.jsmta.service.interfaces;

import org.ihansen.jsmta.domain.UserAuth;

public interface IUserAuthSV {
	/**
	 * 增加用户授权(busId=100001)
	 * @author 吴帅
	 * @parameter @param userAuth
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年12月16日 下午4:50:40
	 */
	public int addUserAuth(UserAuth userAuth) throws Exception;
	
	/**
	 * 获取用户授权(busId=100002)
	 * @author 吴帅
	 * @parameter @param userId
	 * @parameter @return
	 * @parameter @throws Exception
	 * @createDate 2015年12月16日 下午4:51:42
	 */
	public UserAuth getUserAuthByUserId(String userId) throws Exception;
}
