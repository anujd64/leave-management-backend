package com.excelr.groupfive.backend.models;

import jakarta.persistence.*;

import java.sql.Date;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    private LeaveType leaveType;

    private Date startDate;
    private Date endDate;
    private String status;
    private String managerFeedback;
    private String reason;
    private Date createdAt;
    private Date updatedAt;

}
