package com.excelr.groupfive.backend.controller;

import com.excelr.groupfive.backend.models.LeaveType;
import com.excelr.groupfive.backend.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/leave-types")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    @PostMapping("/create")
    public ResponseEntity<Object> createLeaveType(@RequestBody LeaveType leaveType) {
        Optional<LeaveType> existingLeaveTypeOptional = leaveTypeService.getLeaveByName(leaveType.getLeaveTypeName());
        if (existingLeaveTypeOptional.isEmpty()){
            LeaveType newLeaveType = leaveTypeService.createLeaveType(leaveType);
            return ResponseEntity.ok(newLeaveType);
        }
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errMsg","LeaveType already exists!");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMap);
    }

    @PostMapping("/create-multiple")
    public ResponseEntity<List<LeaveType>> createMultipleLeaveTypes(@RequestBody List<LeaveType> leaveTypes) {
        List<LeaveType> createdLeaveTypes = leaveTypeService.createMultipleLeaveTypes(leaveTypes);
        return new ResponseEntity<>(createdLeaveTypes, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveType> getLeaveTypeById(@PathVariable UUID id) {
        LeaveType leaveType = leaveTypeService.getLeaveTypeById(id);
        if (leaveType != null) {
            return ResponseEntity.ok(leaveType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<LeaveType>> getAllLeaveTypes() {
        List<LeaveType> leaveTypes = leaveTypeService.getAllLeaveTypes();
        return ResponseEntity.ok(leaveTypes);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LeaveType> updateLeaveType(@PathVariable UUID id, @RequestBody LeaveType leaveType) {
        LeaveType updatedLeaveType = leaveTypeService.updateLeaveType(id, leaveType);
        if (updatedLeaveType != null) {
            return ResponseEntity.ok(updatedLeaveType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLeaveType(@PathVariable UUID id) {
        leaveTypeService.deleteLeaveType(id);
        return ResponseEntity.ok().build();
    }
}
