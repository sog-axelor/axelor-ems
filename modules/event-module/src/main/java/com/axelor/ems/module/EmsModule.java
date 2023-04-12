package com.axelor.ems.module;

import com.axelor.app.AxelorModule;
import com.axelor.ems.service.EmsService;
import com.axelor.ems.serviceImpl.EmsServiceImpl;

public class EmsModule extends AxelorModule {
	
	@Override
	protected void configure() {
		bind(EmsService.class).to(EmsServiceImpl.class);
	}
}
