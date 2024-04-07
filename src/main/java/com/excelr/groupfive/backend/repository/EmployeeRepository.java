package com.excelr.groupfive.backend.repository;

import com.excelr.groupfive.backend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByUsername(String username);
    Employee findByEmail(String email);

    List<Employee> findByDepartmentId(UUID deptId);
    Employee findByDepartmentIdAndIsManager(UUID deptId, Boolean isManager);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
