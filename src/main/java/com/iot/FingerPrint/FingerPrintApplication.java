package com.iot.FingerPrint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FingerPrintApplication {
	/*
	* centralized system for ESP32 devices
	* */
	public static void main(String[] args) {
		SpringApplication.run(FingerPrintApplication.class, args);
	}
}
