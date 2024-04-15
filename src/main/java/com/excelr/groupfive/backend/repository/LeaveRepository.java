package com.excelr.groupfive.backend.repository;

import com.excelr.groupfive.backend.models.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, UUID> {
    Optional<List<LeaveRequest>> findByEmployeeId(UUID empId);
    Optional<LeaveRequest> findByRequestId(UUID id);
    Optional<List<LeaveRequest>> findByEmployeeIdAndStatus(UUID empId, String status);

    Boolean existsByEmployeeIdAndStartDateAndEndDateAndStatus(UUID empId,Date startDate, Date endDate,String status);
    LeaveRequest findByStatus(String status);
}
