package com.excelr.groupfive.backend.repository;

import com.excelr.groupfive.backend.models.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, UUID> {
    Optional<List<LeaveRequest>> findByEmployeeId(UUID empId);
    Optional<LeaveRequest> findByRequestId(UUID id);
    Optional<List<LeaveRequest>> findByEmployeeIdAndStatus(UUID empId, String status);
    LeaveRequest findByStatus(String status);
}
