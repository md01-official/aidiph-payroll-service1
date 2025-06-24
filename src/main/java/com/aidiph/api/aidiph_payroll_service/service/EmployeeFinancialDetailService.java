package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeeFinancialDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeeFinancialDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface EmployeeFinancialDetailService {
    SuccessResponse createEmployeeFinancialDetail(EmployeeFinancialDetailRequest request);

    EmployeeFinancialDetailResponse getEmployeeFinancialDetailById(UUID id);

    List<EmployeeFinancialDetailResponse> getAllEmployeeFinancialDetails();

    SuccessResponse updateEmployeeFinancialDetail(UUID id, EmployeeFinancialDetailRequest request);
}
