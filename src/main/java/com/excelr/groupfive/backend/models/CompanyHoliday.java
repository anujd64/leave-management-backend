package com.excelr.groupfive.backend.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.UUID;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "company_holidays")
public class CompanyHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID holidayId;

    @Column(name = "holiday_date")
    private Date holidayDate;

    private String description;

}
