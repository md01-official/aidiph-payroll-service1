package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeePersonalDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeePersonalDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeePersonDetailEntity;

import java.util.List;
import java.util.UUID;

public interface EmployeePersonalDetailService {
    SuccessResponse addEmployeeDetail(EmployeePersonalDetailRequest employeePersonalDetail);

    List<EmployeePersonalDetailResponse> getAllEmployeeDetails();

    EmployeePersonalDetailResponse getEmployeeDetailById(UUID id);

    SuccessResponse updateEmployeeDetail(UUID id, EmployeePersonalDetailRequest employeePersonalDetail);
}
