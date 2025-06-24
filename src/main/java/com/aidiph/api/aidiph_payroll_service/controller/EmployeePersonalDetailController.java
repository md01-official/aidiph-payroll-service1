package com.aidiph.api.aidiph_payroll_service.controller;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeePersonalDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeePersonalDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeePersonDetailEntity;
import com.aidiph.api.aidiph_payroll_service.service.EmployeePersonalDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/v1/payroll-service/employee-personal-details")
@RequiredArgsConstructor
public class EmployeePersonalDetailController {
    private final EmployeePersonalDetailService employeePersonalDetailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse addEmployeePersonalDetail(@Valid @RequestBody EmployeePersonalDetailRequest employeePersonalDetail) {
        log.info("Adding employee personal detail for employee ID: {}");
        return employeePersonalDetailService.addEmployeeDetail(employeePersonalDetail);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeePersonalDetailResponse> getAllEmployeePersonalDetails() {
        log.info("Fetching all employee personal details");
        return employeePersonalDetailService.getAllEmployeeDetails();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeePersonalDetailResponse getEmployeePersonalDetailById(@PathVariable UUID id) {
        log.info("Fetching employee personal detail for employee ID: {}", id);
        return employeePersonalDetailService.getEmployeeDetailById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse updateEmployeePersonalDetail(
            @PathVariable UUID id,
            @Valid @RequestBody EmployeePersonalDetailRequest employeePersonalDetail) {
        log.info("Updating employee personal detail for employee ID: {}", id);
        return employeePersonalDetailService.updateEmployeeDetail(id, employeePersonalDetail);
    }



}
