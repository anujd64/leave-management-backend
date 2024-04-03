package com.excelr.groupfive.backend.service;

import com.excelr.groupfive.backend.models.Employee;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface EmployeeService extends UserDetailsService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    Employee updateEmployee(String id, Employee employee);
    void deleteEmployee(String id);
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
