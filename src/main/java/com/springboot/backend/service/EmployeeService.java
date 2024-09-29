package com.springboot.backend.service;

import com.springboot.backend.model.Employee;

import java.util.List;

public interface EmployeeService {
Employee addEmployee(Employee employee);
Employee updateEmployee(Employee employee, Long id);
Employee getEmployeeById(long id);
void  deleteEmployee(long id);
List<Employee> getAllEmployees();
}
