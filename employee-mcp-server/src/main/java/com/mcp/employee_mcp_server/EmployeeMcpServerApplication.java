package com.mcp.employee_mcp_server;

import com.mcp.employee_mcp_server.tools.EmployeeTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMcpServerApplication.class, args);

		System.out.println("Employee mcp server is started : ");
//		npx @modelcontextprotocol/inspector

	}



}
