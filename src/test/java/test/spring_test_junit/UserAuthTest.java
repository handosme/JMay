package test.spring_test_junit;


import org.ihansen.jsmta.domain.UserAuth;
import org.ihansen.jsmta.service.interfaces.IUserAuthSV;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAuthTest extends BaseJunit4Test{
	
	@Autowired
	IUserAuthSV userAuthSV;
	
	@Test
	public void testAddUserAuth() throws Exception {
		UserAuth userAuth = new UserAuth();
		userAuth.setUserId("user1");
		userAuth.setAuthId("user1");
		userAuthSV.addUserAuth(userAuth);
	}
	
	@Test
	public void getUserAuthByUserId() throws Exception {
		UserAuth userAuth = userAuthSV.getUserAuthByUserId("user1");
		System.out.println(userAuth);
	}
}
