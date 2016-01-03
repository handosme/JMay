package org.ihansen.jsmta.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ihansen.jsmta.dao.interfaces.IUserAuthDAO;
import org.ihansen.jsmta.domain.UserAuth;
import org.ihansen.jsmta.domain.UserAuthEX;
import org.ihansen.jsmta.service.interfaces.IBusLogSV;
import org.ihansen.jsmta.service.interfaces.IUserAuthSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthSVImpl implements IUserAuthSV{
	
	private static transient Log log = LogFactory.getLog(UserAuthSVImpl.class);
	
	@Autowired
	private IUserAuthDAO userAuthDAO;
	
	@Autowired
	private IBusLogSV busLogSV;
	

	@Override
	public int addUserAuth(UserAuth userAuth) throws Exception {
		int count = 0;
		if(userAuth!=null){
			count = userAuthDAO.add(userAuth);
			busLogSV.log("100001", "0000");//记录本次操作
			System.out.println("ok");
		}
		return count;
	}

	@Override
	public UserAuth getUserAuthByUserId(String userId) throws Exception {
		UserAuthEX userAuthEX = new UserAuthEX();
		userAuthEX.createCriteria().andUserIdEqualTo(userId);
		busLogSV.log("100002", "0000");
		return userAuthDAO.qrySingleByCondition(userAuthEX);
	}
	
}
