package com.mcp.employee_mcp_server.tools;

import com.mcp.employee_mcp_server.dtos.CreateEmployeeRequest;
import com.mcp.employee_mcp_server.entities.Employee;
import com.mcp.employee_mcp_server.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EmployeeTools {

    private final EmployeeService employeeService;

    @McpTool(
            name = "create_employee",
            description = "Create a new employee using the username and role."
    )
    public Employee createEmployee(CreateEmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @McpTool(
            name = "get_employee_by_id",
            description = "Retrieve an employee using the employee id."
    )
    public Employee getEmployeeById(@McpToolParam(description = "employee Id",required = true) Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @McpTool(
            name = "get_all_employees",
            description = "Retrieve all employees."
    )
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @McpTool(
            name = "delete_employee",
            description = "Delete an employee using the employee id."
    )
    public String deleteEmployee(@McpToolParam(description = "employee Id",required = true) Long employeeId) {

        employeeService.deleteById(employeeId);

        return "Employee deleted successfully.";
    }

    @McpTool(
            name = "search_employee_by_name",
            description = "Search employees by username. The search is case-insensitive and supports partial matches."
    )
    public List<Employee> searchEmployeeByName(
            @McpToolParam(description = "Employee name",required = true) String username) {
        return employeeService.getEmployeeByName(username);
    }


}
