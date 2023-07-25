package com.retooling.date.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

	@GetMapping(path = "get-date")
	public String getFileDate() throws Exception {
		logger.info("Controller - Calling method getFileDate...");

		String file = "config/fileAmountDays.txt";
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String amountDays = reader.readLine();
		reader.close();
		
		Date currentDate = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, Integer.valueOf(amountDays));
		currentDate = c.getTime();
		
		return (new SimpleDateFormat("yyyyMMddHHmmss").format(currentDate));
	}

	@PostMapping(path = "set-date")
	public String addDays(@RequestBody String amountDays) throws IOException {
		logger.info("Controller - Calling method addDays...");

		String file = "config/fileAmountDays.txt";
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String daysInFile = reader.readLine();
		reader.close();
		
		FileWriter f = new FileWriter(file,false);
		BufferedWriter b = new BufferedWriter(f);
		PrintWriter p = new PrintWriter(b);
		p.println(Integer.parseInt(amountDays) + Integer.parseInt(daysInFile));
		p.close();
		
		return "OK";				
	}
	
}
