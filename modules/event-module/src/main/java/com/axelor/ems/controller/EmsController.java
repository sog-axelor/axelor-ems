package com.axelor.ems.controller;

import javax.inject.Inject;

import com.axelor.ems.db.Discount;
import com.axelor.ems.db.Event;
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
	

	
	
	
}
