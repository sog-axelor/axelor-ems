package com.axelor.ems.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.axelor.ems.db.Discount;
import com.axelor.ems.db.Event;
import com.axelor.ems.db.EventRegistration;
import com.axelor.ems.service.EmsService;

public class EmsServiceImpl implements EmsService {

	@Override
	public Event countEntry(Event er) {

		long totalEntry = er.getEventregistration().stream().count();
		int te = (int) totalEntry;
		er.setTotalentry(te);
		return er;
	}

	@Override
	public Event totalAmount(Event er) {
		BigDecimal totalAmount = BigDecimal.ZERO;
		totalAmount = er.getEventregistration().stream().map(EventRegistration::getAmount).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		er.setAmountcollect(totalAmount);
		return er;
	}

	@Override
	public Discount totalDiscoint(Discount d, Event e) {
		BigDecimal fee = e.getEventfee();
		BigDecimal amount = d.getDiscount_percent().multiply(fee).divide(new BigDecimal(100));
		d.setDiscount_amount(amount);
		return d;
	}



	

	@Override
	public LocalDate checkDate(Discount d, Event e) {
		LocalDate date = e.getRegclose();
		int days = d.getBefore_days();
		LocalDate newDate = date.minusDays(days);
		return newDate;
	}




	


}



