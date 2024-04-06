package com.excelr.groupfive.backend.service;

import com.excelr.groupfive.backend.models.LeaveType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeaveTypeService {
    LeaveType createLeaveType(LeaveType leaveType);

    Optional<LeaveType> getLeaveByName(String name);
    List<LeaveType> createMultipleLeaveTypes(List<LeaveType> leaveTypes);
    LeaveType getLeaveTypeById(UUID id);
    List<LeaveType> getAllLeaveTypes();
    LeaveType updateLeaveType(UUID id, LeaveType leaveType);
    void deleteLeaveType(UUID id);
}
