package com.mcp.employee_mcp_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeMcpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMcpClientApplication.class, args);
		System.out.println("mcp client is started.");
	}

}
