package com.axelor.ems.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.Convert;

import com.axelor.ems.db.Discount;
import com.axelor.ems.db.Event;
import com.axelor.ems.db.EventRegistration;
import com.axelor.ems.serviceImpl.EmsServiceImpl;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class EmsController {

	@Inject EmsServiceImpl es;
	
	public void totalGuest(ActionRequest request, ActionResponse response) {
	Event event =  request.getContext().asType(Event.class);
	event = es.countEntry(event);
	response.setValue("totalentry", event.getTotalentry());
	}
	
	
	public void totalAmount(ActionRequest request, ActionResponse response) {
		Event event =  request.getContext().asType(Event.class);
		event = es.totalAmount(event);
		response.setValue("amountcollect", event.getAmountcollect());
	}
	

	public void discountAmount(ActionRequest request, ActionResponse response) {
		Discount discount =  request.getContext().asType(Discount.class);
		Event e=request.getContext().getParentContext().asType(Event.class);
		discount = es.totalDiscoint(discount, e);
		response.setValue("discount_amount", discount.getDiscount_amount());
	}
	
	
	public void totalDiscountAmount(ActionRequest request, ActionResponse response) {
		Event event =  request.getContext().asType(Event.class);
		event = es.totalDiscountAmount(event);
		response.setValue("totaldisc", event.getTotaldisc());
	}
	
	public void capicity(ActionRequest request, ActionResponse response) {
		Event event =  request.getContext().asType(Event.class);
		event = es.countEntry(event);
		boolean isSame = event.getCapacity().equals(event);
	      if(!isSame) {
	            response.setError("Capicity Excced" );
	        }
	}
	
	public static LocalDate convert(LocalDateTime dateTime) {
        return dateTime.toLocalDate();
    }
	
	public void checkDate(ActionRequest request, ActionResponse response) {
		
	
		//Event event =request.getContext().asType(Event.class);
		//System.err.println(event.getRegopen());
		//System.err.println(event.getRegclose());
		
		
		Event event=request.getContext().getParentContext().asType(Event.class);
		System.err.println(event.getRegopen());
		System.err.println(event.getRegclose());
		
	
//        LocalDateTime dateTime = er.getRegdate();
//        
//
//		LocalDate date = convert(dateTime);
//		LocalDate regD = event.getRegopen();
//		LocalDate colD = event.getRegclose();
//		if (date.isAfter(regD) && date.isBefore(colD)) {
//		    System.out.println("Datetime is between start and end");
//		} else {
//		   response.setError("Date is closed");
//		}
		

	}
}
