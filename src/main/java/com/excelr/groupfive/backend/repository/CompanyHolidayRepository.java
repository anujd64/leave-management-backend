package com.excelr.groupfive.backend.repository;

import com.excelr.groupfive.backend.models.CompanyHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyHolidayRepository extends JpaRepository<CompanyHoliday, UUID> {

    Optional<CompanyHoliday> findByHolidayDate(Date date);
}
