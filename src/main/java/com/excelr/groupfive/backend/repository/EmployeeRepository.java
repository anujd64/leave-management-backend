package com.excelr.groupfive.backend.repository;

import com.excelr.groupfive.backend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByUsernameAndHashedPassword(String username, String hashedPassword);
}
