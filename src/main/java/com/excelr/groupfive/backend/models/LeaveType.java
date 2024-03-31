package com.excelr.groupfive.backend.models;

import jakarta.persistence.*;
@Entity
@Table(name = "leave_types")
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveTypeId;

    private String leaveTypeName;
    private int defaultAllowance;

    public Long getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Long leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public int getDefaultAllowance() {
        return defaultAllowance;
    }

    public void setDefaultAllowance(int defaultAllowance) {
        this.defaultAllowance = defaultAllowance;
    }

}
