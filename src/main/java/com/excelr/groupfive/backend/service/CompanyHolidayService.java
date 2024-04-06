package com.excelr.groupfive.backend.service;

import com.excelr.groupfive.backend.models.CompanyHoliday;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyHolidayService {
    CompanyHoliday createCompanyHoliday(CompanyHoliday companyHoliday);
    List<CompanyHoliday> createMultipleCompanyHolidays(List<CompanyHoliday> companyHolidays);
    Optional<CompanyHoliday> getCompanyHolidayById(UUID id);
    Optional<CompanyHoliday> getCompanyHolidayByDate(Date date);

    List<CompanyHoliday> getAllCompanyHolidays();
    CompanyHoliday updateCompanyHoliday(UUID id, CompanyHoliday companyHoliday);
    void deleteCompanyHoliday(UUID id);
}
