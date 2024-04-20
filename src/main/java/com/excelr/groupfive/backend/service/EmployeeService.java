package com.excelr.groupfive.backend.service;

import com.excelr.groupfive.backend.models.Employee;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.UUID;

public interface EmployeeService extends UserDetailsService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(UUID id);
    Employee updateEmployee(UUID id, Employee employee);
    void deleteEmployee(UUID id);

    List<Employee> findByDepartmentId(UUID deptId);

    UserDetails findByUsername(String username);

    Employee findByEmail(String email);

    List<Employee> findByDepartmentIdAndIsManager(UUID departmentId, boolean isManager);

    Employee createEmployee(Employee employee);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
