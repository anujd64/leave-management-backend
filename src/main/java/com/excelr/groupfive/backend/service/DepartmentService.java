package com.excelr.groupfive.backend.service;

import com.excelr.groupfive.backend.models.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(UUID id);
    Department createDepartment(Department department);
    List<Department> createMultipleDepartments(List<Department> departments);
    Department updateDepartment(UUID id, Department department);
    void deleteDepartment(UUID id);
}
