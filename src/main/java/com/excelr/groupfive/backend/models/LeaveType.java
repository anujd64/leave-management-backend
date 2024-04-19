package com.excelr.groupfive.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "leave_types")
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID leaveTypeId;
    private String leaveTypeName;
    private int defaultAllowance;
    private boolean docsRequired;

}
