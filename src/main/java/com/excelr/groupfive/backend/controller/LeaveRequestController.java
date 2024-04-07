package com.excelr.groupfive.backend.controller;

import com.excelr.groupfive.backend.models.LeaveRequest;
import com.excelr.groupfive.backend.service.LeaveRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = {"authorization"})
@RequestMapping("/leaves")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/create-leave")
    public ResponseEntity<Object> createLeaveRequest(@RequestBody LeaveRequest leaveRequest){
        LeaveRequest newLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequest);
        return ResponseEntity.ok(newLeaveRequest);
    }

    @GetMapping("/by-empId/{empId}")
    public ResponseEntity<List<LeaveRequest>> getLeaveRequestByEmployeeId(@PathVariable UUID empId) {
        logger.info("empId in /empId "+ empId);
        List<LeaveRequest> leaveRequest = leaveRequestService.getLeavesByEmployeeId(empId);
        if (leaveRequest != null && !leaveRequest.isEmpty()) {
            return ResponseEntity.ok(leaveRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-empId/{empId}/{status}")
    public ResponseEntity<List<LeaveRequest>> getLeaveRequestByEmployeeId(@PathVariable UUID empId, @PathVariable String status) {
        logger.info("empId in /empId/status "+ empId + " status " + status);
        Optional<List<LeaveRequest>> leaveRequestOptional = leaveRequestService.getLeaveByEmployeeIdAndStatus(empId,status);
        if (leaveRequestOptional.isPresent()) {
            List<LeaveRequest> leaveRequestList = leaveRequestOptional.get();
            return ResponseEntity.ok(leaveRequestList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update-leave/{id}")
    public ResponseEntity<LeaveRequest> updateLeaveRequest(@PathVariable String id, @RequestBody LeaveRequest leaveRequest)
    {
        LeaveRequest updatedleaveRequest = leaveRequestService.updateLeaveRequest(id, leaveRequest);
        if (updatedleaveRequest != null) {
            return ResponseEntity.ok(updatedleaveRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete-leave/{id}")
    public ResponseEntity<Void> deleteLeaveRequest(@PathVariable String id) {
        leaveRequestService.deleteLeaveRequest(id);
        return ResponseEntity.ok().build();
    }
}

