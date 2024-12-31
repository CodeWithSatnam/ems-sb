package com.ems.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsSbApplication {
	static Logger logger = LoggerFactory.getLogger(EmsSbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmsSbApplication.class, args);
		logger.info("####### Application Started #######");
	}

}
