package com.excelr.groupfive.backend.serviceimpl;

import com.excelr.groupfive.backend.models.Employee;
import com.excelr.groupfive.backend.repository.EmployeeRepository;
import com.excelr.groupfive.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public Employee updateEmployee(UUID id, Employee employee) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();

            // Update only changed fields using Java reflection
            try {
                updateEmployeeFields(existingEmployee, employee);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            return employeeRepository.save(existingEmployee);
        } else {
            return null; // or throw an exception
        }
    }

    private void updateEmployeeFields(Employee existingEmployee, Employee updateEmployee) throws IllegalAccessException {
        for (Field field : updateEmployee.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object updateValue = field.get(updateEmployee);
            if (updateValue != null) { // Check for non-null value before update
                field.set(existingEmployee, updateValue);
            }
        }
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository.findByUsername(username);
    }

    @Override
    public List<Employee> findByDepartmentId(UUID deptId) {
        return employeeRepository.findByDepartmentId(deptId);
    }

    @Override
    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Employee findByDepartmentIdAndIsManager(UUID departmentId, boolean isManager) {
        return employeeRepository.findByDepartmentIdAndIsManager(departmentId,isManager);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return employeeRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }
}
