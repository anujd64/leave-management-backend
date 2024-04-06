package com.excelr.groupfive.backend.serviceimpl;

import com.excelr.groupfive.backend.models.CompanyHoliday;
import com.excelr.groupfive.backend.repository.CompanyHolidayRepository;
import com.excelr.groupfive.backend.service.CompanyHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyHolidayServiceImpl implements CompanyHolidayService {

    @Autowired
    private CompanyHolidayRepository companyHolidayRepository;

    @Override
    public CompanyHoliday createCompanyHoliday(CompanyHoliday companyHoliday) {
        return companyHolidayRepository.save(companyHoliday);
    }

    @Override
    public List<CompanyHoliday> createMultipleCompanyHolidays(List<CompanyHoliday> companyHolidays) {
        return companyHolidayRepository.saveAll(companyHolidays);
    }

    @Override
    public Optional<CompanyHoliday> getCompanyHolidayById(UUID id) {
        return companyHolidayRepository.findById(id);
    }

    @Override
    public Optional<CompanyHoliday> getCompanyHolidayByDate(Date date) {
        return companyHolidayRepository.findByHolidayDate(date);
    }

    @Override
    public List<CompanyHoliday> getAllCompanyHolidays() {
        return companyHolidayRepository.findAll();
    }

    @Override
    public CompanyHoliday updateCompanyHoliday(UUID id, CompanyHoliday companyHoliday) {
        if (companyHolidayRepository.existsById(id)) {
            companyHoliday.setHolidayId(id);
            return companyHolidayRepository.save(companyHoliday);
        }
        return null;
    }

    @Override
    public void deleteCompanyHoliday(UUID id) {
        companyHolidayRepository.deleteById(id);
    }
}
