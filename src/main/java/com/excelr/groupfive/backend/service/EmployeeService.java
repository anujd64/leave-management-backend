package com.excelr.groupfive.backend.service;

import com.excelr.groupfive.backend.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    Employee authenticate(String username, String password);
    void deleteEmployee(Long id);
}
