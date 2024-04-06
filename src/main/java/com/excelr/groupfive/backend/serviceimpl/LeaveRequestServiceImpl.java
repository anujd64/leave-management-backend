package com.excelr.groupfive.backend.serviceimpl;

import com.excelr.groupfive.backend.models.Employee;
import com.excelr.groupfive.backend.models.LeaveRequest;
import com.excelr.groupfive.backend.repository.LeaveRepository;
import com.excelr.groupfive.backend.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
    private final LeaveRepository leaveRepository;

    public LeaveRequestServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRepository.save(leaveRequest);
    }

    @Override
    public Optional<LeaveRequest> getLeaveById(String id) {
        return leaveRepository.findByRequestId(UUID.fromString(id));
    }

    @Override
    public Optional<List<LeaveRequest>> getLeaveByEmployeeIdAndStatus(UUID id, String status) {
        return leaveRepository.findByEmployeeIdAndStatus(id, status);
    }

    @Override
    public List<LeaveRequest> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public List<LeaveRequest> getLeavesByEmployeeId(UUID empId) {
        Optional<List<LeaveRequest>> leaveRequestList =leaveRepository.findByEmployeeId(empId);
        return leaveRequestList.orElse(null);
    }
    @Override
    public LeaveRequest updateLeaveRequest(String id, LeaveRequest leaveRequest) {
        Optional<LeaveRequest> existingLeaveOptional = leaveRepository.findById(UUID.fromString(id));
        if (existingLeaveOptional.isPresent()) {
            LeaveRequest existingLeave = existingLeaveOptional.get();

            // Update only changed fields using Java reflection
            try {
                updateLeaveRequestFields(existingLeave, leaveRequest);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            return leaveRepository.save(existingLeave);
        } else {
            return null; // or throw an exception
        }
    }

    private void updateLeaveRequestFields(LeaveRequest existingLeaveRequest, LeaveRequest updateLeaveRequest) throws IllegalAccessException {
        for (Field field : LeaveRequest.class.getDeclaredFields()) {
            field.setAccessible(true);
            Object updateValue = field.get(updateLeaveRequest);
            if (updateValue != null) { // Check for non-null value before update
                field.set(existingLeaveRequest, updateValue);
            }
        }
    }
    @Override
    public void deleteLeaveRequest(String id) {
        leaveRepository.deleteById(UUID.fromString(id));
    }
}
