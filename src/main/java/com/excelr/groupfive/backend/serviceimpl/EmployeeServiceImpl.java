package com.excelr.groupfive.backend.serviceimpl;

import com.excelr.groupfive.backend.models.Employee;
import com.excelr.groupfive.backend.repository.EmployeeRepository;
import com.excelr.groupfive.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setUsername(employee.getUsername());
            existingEmployee.setHashedPassword(employee.getHashedPassword());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setGender(employee.getGender());
            existingEmployee.setFullName(employee.getFullName());
            existingEmployee.setDepartmentId(employee.getDepartmentId());
            existingEmployee.setManagerId(employee.getManagerId());

            return employeeRepository.save(existingEmployee);
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public Employee authenticate(String username, String password) {
        String hashedPassword = password;
        Employee employee = employeeRepository.findByUsernameAndHashedPassword(username, password);
        return employee;
    }
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
