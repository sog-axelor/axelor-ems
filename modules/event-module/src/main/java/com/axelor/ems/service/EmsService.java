package com.axelor.ems.service;


import java.time.LocalDate;
import java.util.Date;

import com.axelor.ems.db.Discount;
import com.axelor.ems.db.Event;

public interface EmsService {
	 public Event countEntry(Event er);
	 public Event totalAmount(Event er);
	 public Discount totalDiscoint(Discount d, Event e);
	 public Event totalDiscountAmount(Event er);
	 public void totalCapicity(Event er);

}
