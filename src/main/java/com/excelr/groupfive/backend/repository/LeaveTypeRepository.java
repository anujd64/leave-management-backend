package com.excelr.groupfive.backend.repository;

import com.excelr.groupfive.backend.models.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, UUID> {

    Optional<LeaveType> findByLeaveTypeName(String leaveTypeName);
}
