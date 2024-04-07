package com.excelr.groupfive.backend.controller;

import com.excelr.groupfive.backend.models.Department;
import com.excelr.groupfive.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = {"authorization"})
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable UUID id) {
        Department department = departmentService.getDepartmentById(id);
        if (department.getDepartmentId() != null){
            return new ResponseEntity<>(department, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Object> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errMsg","Department Already Exsists!!");
        if (createdDepartment == null) return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMap);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    @PostMapping("/create-multiple")
    public ResponseEntity<List<Department>> createMultipleDepartments(@RequestBody List<Department> departments) {
        List<Department> createdDepartments = departmentService.createMultipleDepartments(departments);
        return new ResponseEntity<>(createdDepartments, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable UUID id, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
