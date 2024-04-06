package com.excelr.groupfive.backend.serviceimpl;

import com.excelr.groupfive.backend.models.LeaveType;
import com.excelr.groupfive.backend.repository.LeaveTypeRepository;
import com.excelr.groupfive.backend.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Override
    public LeaveType createLeaveType(LeaveType leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

    @Override
    public Optional<LeaveType> getLeaveByName(String name) {
        return leaveTypeRepository.findByLeaveTypeName(name);
    }

    @Override
    public List<LeaveType> createMultipleLeaveTypes(List<LeaveType> leaveTypes) {
        return leaveTypeRepository.saveAll(leaveTypes);
    }

    @Override
    public LeaveType getLeaveTypeById(UUID id) {
        return leaveTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    @Override
    public LeaveType updateLeaveType(UUID id, LeaveType leaveType) {
        if (leaveTypeRepository.existsById(id)) {
            leaveType.setLeaveTypeId(id);
            return leaveTypeRepository.save(leaveType);
        }
        return null;
    }

    @Override
    public void deleteLeaveType(UUID id) {
        leaveTypeRepository.deleteById(id);
    }
}
