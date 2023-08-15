package com.retooling.date.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SimulatorDateController {

	private static final Logger logger = LoggerFactory.getLogger(SimulatorDateController.class);

	private int amountDays;
	
	@GetMapping(path = "get-date")
	public String getDate() throws Exception {
		logger.info("Controller - Calling method getDate...");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, amountDays);
		currentDate = c.getTime();		
		return (new SimpleDateFormat("yyyyMMddHHmmss").format(currentDate));
	}

	@PostMapping(path = "set-date")
	public String addDays(@RequestBody int reqAmountDays) throws IOException {
		logger.info("Controller - Calling method addDays...");
		amountDays = amountDays + reqAmountDays;
		return "OK";				
	}
	
}
