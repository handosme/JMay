package org.ihansen.jsmta.dao.impl;

import org.ihansen.jsmta.dao.interfaces.IUserAuthDAO;
import org.ihansen.jsmta.domain.UserAuth;
import org.ihansen.jsmta.domain.UserAuthEX;
import org.ihansen.jsmta.domain.operate.UserAuthMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserAuthDAOImpl extends CommonDAOImpl<UserAuth, UserAuthMapper, UserAuthEX> implements IUserAuthDAO {

}
