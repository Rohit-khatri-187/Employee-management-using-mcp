package com.mcp.employee_mcp_server.services;


import com.mcp.employee_mcp_server.dtos.CreateEmployeeRequest;
import com.mcp.employee_mcp_server.dtos.UpdateEmployeeRequest;
import com.mcp.employee_mcp_server.entities.Employee;
import com.mcp.employee_mcp_server.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(CreateEmployeeRequest request){
        log.info("Inside the create Employee() : ");
        Employee employee = Employee.builder()
                .name(request.getUsername())
                .role(request.getRole())
                .build();

        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long empId){

        log.info("Inside the getEmployeeById() :  ");

        return employeeRepository.findById(empId)
                .orElseThrow(()-> new RuntimeException("Employee not found . "));

    }

    public List<Employee> getAllEmployees(){
        log.info("Inside the get All employees : ");

        return employeeRepository.findAll();
    }

    public Employee updateEmployee(UpdateEmployeeRequest request){
        log.info("Inside updateEmployee() :  ");

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(()-> new RuntimeException("Employee not found"));

        employee.setName(request.getUsername());
        employee.setRole(request.getRole());

        return employeeRepository.save(employee);

    }

    public void deleteById(Long empId){

        log.info("Inside the deleteById() :  ");

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(()-> new RuntimeException("Employee not found . "));

        employeeRepository.deleteById(empId);

    }

    public List<Employee> getEmployeeByName(String userName){

        log.info("inside getEmployeeByName() :  ");

        return employeeRepository.searchEmployeesByName(userName);
    }


}
