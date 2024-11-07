package com.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Inditex application.
 * This class initializes and runs the Spring Boot application.
 */
@SpringBootApplication(scanBasePackages = "com.inditex")
public class InditexApplication {

	/**
	 * Main method to start the Spring Boot application.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(InditexApplication.class, args);
	}

}
