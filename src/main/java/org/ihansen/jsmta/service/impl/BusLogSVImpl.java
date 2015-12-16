package org.ihansen.jsmta.service.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ihansen.jsmta.dao.interfaces.IBusLogDAO;
import org.ihansen.jsmta.domain.BusLog;
import org.ihansen.jsmta.service.interfaces.IBusLogSV;
import org.ihansen.jsmta.utils.BeanSetDefVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusLogSVImpl implements IBusLogSV {

	private static transient Log log = LogFactory.getLog(BusLogSVImpl.class);
	
	@Autowired
	private IBusLogDAO busLogDAO;
	
	@Override
	public int log(String busId, String operatorId) throws Exception {
		BusLog busLog = new BusLog();
		busLog.setBusId(busId);
		busLog.setOperatorId(operatorId);
		busLog.setResult("S");
		BeanSetDefVal.setCreateDefValue(busLog);
		log.debug("记录操作"+operatorId+"/"+busId);
		return busLogDAO.add(busLog);
	}
	
}
