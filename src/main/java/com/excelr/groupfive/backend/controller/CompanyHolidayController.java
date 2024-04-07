package com.excelr.groupfive.backend.controller;

import com.excelr.groupfive.backend.models.CompanyHoliday;
import com.excelr.groupfive.backend.service.CompanyHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = {"authorization"})
@RequestMapping("/company-holidays")
public class CompanyHolidayController {

    @Autowired
    private CompanyHolidayService companyHolidayService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCompanyHoliday(@RequestBody CompanyHoliday companyHoliday) {
        Optional<CompanyHoliday> existingHolidayOptional = companyHolidayService.getCompanyHolidayByDate(companyHoliday.getHolidayDate());
        if (existingHolidayOptional.isPresent()){
            String errorMessage = "Holiday Already Set!";
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("errMsg", errorMessage);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMap);
        }
        CompanyHoliday newCompanyHoliday = companyHolidayService.createCompanyHoliday(companyHoliday);
        return ResponseEntity.ok(newCompanyHoliday);
    }

    @PostMapping("/create-multiple")
    public ResponseEntity<List<CompanyHoliday>> createMultipleCompanyHolidays(@RequestBody List<CompanyHoliday> companyHolidays) {
        List<CompanyHoliday> createdHolidays = companyHolidayService.createMultipleCompanyHolidays(companyHolidays);
        return ResponseEntity.ok(createdHolidays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyHoliday> getCompanyHolidayById(@PathVariable UUID id) {
        Optional<CompanyHoliday> companyHoliday = companyHolidayService.getCompanyHolidayById(id);
        return companyHoliday.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompanyHoliday>> getAllCompanyHolidays() {
        List<CompanyHoliday> companyHolidays = companyHolidayService.getAllCompanyHolidays();
        return ResponseEntity.ok(companyHolidays);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyHoliday> updateCompanyHoliday(@PathVariable UUID id, @RequestBody CompanyHoliday companyHoliday) {
        CompanyHoliday updatedCompanyHoliday = companyHolidayService.updateCompanyHoliday(id, companyHoliday);
        return ResponseEntity.ok(updatedCompanyHoliday);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompanyHoliday(@PathVariable UUID id) {
        companyHolidayService.deleteCompanyHoliday(id);
        return ResponseEntity.ok().build();
    }
}
