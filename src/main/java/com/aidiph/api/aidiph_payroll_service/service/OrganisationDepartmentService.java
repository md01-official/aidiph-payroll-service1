package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDepartmentRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationDepartmentResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface OrganisationDepartmentService {
    SuccessResponse createDepartment(OrganisationDepartmentRequest request);

    OrganisationDepartmentResponse getDepartmentById(UUID id);

    List<OrganisationDepartmentResponse> getAllDepartments();

    SuccessResponse updateDepartment(UUID id, @Valid OrganisationDepartmentRequest request);
}
