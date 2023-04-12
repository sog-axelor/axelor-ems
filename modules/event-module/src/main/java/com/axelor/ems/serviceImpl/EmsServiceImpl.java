package com.axelor.ems.serviceImpl;


import java.math.BigDecimal;

import com.axelor.ems.db.Event;
import com.axelor.ems.db.EventRegistration;
import com.axelor.ems.service.EmsService;

public class EmsServiceImpl implements EmsService {

	@Override
	public Event countEntry(Event er) {
		 
		long totalEntry = er.getEventregistration().stream().count();
		int  te =(int)totalEntry; 
		er.setTotalentry(te);
		return er;
	}

	@Override
	public Event totalAmount(Event er) {
		BigDecimal totalAmount = BigDecimal.ZERO;
		totalAmount = er.getEventregistration().stream().map(EventRegistration::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
		er.setAmountcollect(totalAmount);
		return er;
	}


	
}
