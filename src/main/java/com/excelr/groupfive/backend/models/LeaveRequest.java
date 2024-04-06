package com.excelr.groupfive.backend.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "leave_requests")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID requestId;
    private UUID employeeId;
    private String leaveTypeId;
    private Date startDate;
    private Date endDate;
    private String status;
    private String managerFeedback;
    private String reason;
    private Date createdAt;
    private Date updatedAt;

}
