package org.ihansen.jsmta.dao.impl;

import org.ihansen.jsmta.dao.interfaces.IBusLogDAO;
import org.ihansen.jsmta.domain.BusLog;
import org.ihansen.jsmta.domain.BusLogEX;
import org.ihansen.jsmta.domain.operate.BusLogMapper;
import org.springframework.stereotype.Repository;


@Repository
public class BusLogDAO extends CommonDAOImpl<BusLog,BusLogMapper,BusLogEX> implements IBusLogDAO {

}
