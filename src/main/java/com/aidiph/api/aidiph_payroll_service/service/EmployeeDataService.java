package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeeDataRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeeDataResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface EmployeeDataService {
    SuccessResponse createEmployee(@Valid EmployeeDataRequest request);
    EmployeeDataResponse getEmployeeById(UUID id);
    List<EmployeeDataResponse> getAllEmployees();
    SuccessResponse updateEmployee(UUID id, @Valid EmployeeDataRequest request) ;
}
