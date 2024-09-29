package com.springboot.backend.service.Impl;

import com.springboot.backend.model.Employee;
import com.springboot.backend.repository.EmployeeRepository;
import com.springboot.backend.service.EmployeeService;
import com.springboot.backend.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        // we need to check whether employee with given id exists in DB or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setEmp_name(employee.getEmp_name());
        existingEmployee.setEmp_email(employee.getEmp_email());
        existingEmployee.setEmp_age(employee.getEmp_age());

        return existingEmployee;
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id",id));
    }

    @Override
    public void deleteEmployee(long id) {
        // check whether an employee exist in a DB or not
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
