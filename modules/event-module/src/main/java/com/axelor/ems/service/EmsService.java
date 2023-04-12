package com.axelor.ems.service;

import com.axelor.ems.db.Event;

public interface EmsService {
	 public Event countEntry(Event er);
	 public Event totalAmount(Event er);
}
