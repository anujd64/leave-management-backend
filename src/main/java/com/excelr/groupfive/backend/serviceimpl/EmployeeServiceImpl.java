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
    public Employee getEmployeeById(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
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
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository.findByUsername(username);
    }
}
