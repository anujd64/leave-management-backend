package com.excelr.groupfive.backend.repository;

import com.excelr.groupfive.backend.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    boolean existsByDepartmentName(String departmentName);
}
