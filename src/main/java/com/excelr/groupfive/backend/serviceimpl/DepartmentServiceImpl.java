package com.excelr.groupfive.backend.serviceimpl;

import com.excelr.groupfive.backend.models.Department;
import com.excelr.groupfive.backend.repository.DepartmentRepository;
import com.excelr.groupfive.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(UUID id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department createDepartment(Department department) {
        if (departmentRepository.existsByDepartmentName(department.getDepartmentName())) {
            return null;
        }
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> createMultipleDepartments(List<Department> departments) {
        departments.removeIf(department -> departmentRepository.existsByDepartmentName(department.getDepartmentName()));
        return departmentRepository.saveAll(departments);
    }

    @Override
    public Department updateDepartment(UUID id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setDepartmentId(id);
            return departmentRepository.save(department);
        }
        return null;
    }

    @Override
    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }
}
