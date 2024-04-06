package com.excelr.groupfive.backend.service;

import com.excelr.groupfive.backend.models.LeaveRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeaveRequestService {

    LeaveRequest createLeaveRequest(LeaveRequest leaveRequest);
    Optional<LeaveRequest> getLeaveById(String id);
    Optional<List<LeaveRequest>> getLeaveByEmployeeIdAndStatus(UUID empId, String status);
    List<LeaveRequest> getAllLeaves();
    List<LeaveRequest> getLeavesByEmployeeId(UUID empId);
    LeaveRequest updateLeaveRequest(String id, LeaveRequest leaveRequest);
    void deleteLeaveRequest(String id);
}
