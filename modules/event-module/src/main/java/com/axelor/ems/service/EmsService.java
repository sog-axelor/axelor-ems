package com.axelor.ems.service;

import java.time.LocalDate;

import com.axelor.ems.db.Discount;
import com.axelor.ems.db.Event;
import com.axelor.ems.db.EventRegistration;

public interface EmsService {
	 public Event countEntry(Event er);
	 public Event totalAmount(Event er);
	 public Discount totalDiscoint(Discount d, Event e);
	 public Event totalDiscountAmount(Event er);
	 public LocalDate checkDate(Discount d, Event e);

}
