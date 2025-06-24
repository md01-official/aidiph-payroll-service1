package com.aidiph.api.aidiph_payroll_service.controller;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeeFinancialDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeeFinancialDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.service.EmployeeFinancialDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payroll-service/employee-financial-details")
@RequiredArgsConstructor
@Slf4j
public class EmployeeFinancialDetailController {

    private final EmployeeFinancialDetailService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse addEmployeeFinancialDetail(@Valid @RequestBody EmployeeFinancialDetailRequest request) {
        log.info("Adding financial details for Employee ID: {}", request.getEmployeeNumber());
        return service.createEmployeeFinancialDetail(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeFinancialDetailResponse getEmployeeFinancialDetailById(@PathVariable UUID id) {
        log.info("Fetching financial details for Employee ID: {}", id);
        return service.getEmployeeFinancialDetailById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeFinancialDetailResponse> getAllEmployeeFinancialDetails() {
        log.info("Fetching all employee financial details");
        return service.getAllEmployeeFinancialDetails();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse updateEmployeeFinancialDetailById(
            @PathVariable UUID id,
            @Valid @RequestBody EmployeeFinancialDetailRequest request) {
        log.info("Updating financial details for Employee ID: {}", id);
        return service.updateEmployeeFinancialDetail(id, request);
    }

}
