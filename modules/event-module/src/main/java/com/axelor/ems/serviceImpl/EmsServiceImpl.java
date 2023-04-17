package com.axelor.ems.serviceImpl;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.math.BigDecimal;
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
	public Event totalDiscountAmount(Event er) {
		BigDecimal totalDiscountAmount = BigDecimal.ZERO;
		totalDiscountAmount = er.getDiscount().stream().map(Discount::getDiscount_amount).reduce(BigDecimal.ZERO,BigDecimal::add);
		long totalEntry = er.getEventregistration().stream().count();
		er.setTotaldisc(totalDiscountAmount.multiply(new BigDecimal(totalEntry)));
		return er;
	}


	@Override
	public void totalCapicity(Event er) {
		long totalEntry = er.getEventregistration().stream().count();
		int te = (int) totalEntry;
		
	}

	

}
