package com.aidiph.api.aidiph_payroll_service.controller;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeeDataRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeeDataResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.service.EmployeeDataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/v1/payroll-service/employee-data")
@RequiredArgsConstructor
public class EmployeeDataController {
    private final EmployeeDataService employeeDataService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse createEmployee(@Valid @RequestBody EmployeeDataRequest request) {
        log.info("Creating employee with name: {} {}", request.getFirstName(), request.getLastName());
        return employeeDataService.createEmployee(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDataResponse getEmployeeById(@PathVariable UUID id) {
        log.info("Fetching employee details for ID: {}", id);
        return employeeDataService.getEmployeeById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDataResponse> getAllEmployees() {
        log.info("Fetching all employee details");
        return employeeDataService.getAllEmployees();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse updateEmployee(@PathVariable UUID id, @Valid @RequestBody EmployeeDataRequest request) {
        log.info("Updating employee details for ID: {}", id);
        return employeeDataService.updateEmployee(id, request);
    }

}
