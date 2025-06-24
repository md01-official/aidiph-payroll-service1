package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryComponentMasterRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryComponentMasterResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface SalaryComponentMasterService {
    SuccessResponse createSalaryComponent(@Valid SalaryComponentMasterRequest request);

    SalaryComponentMasterResponse getSalaryComponentById(UUID id);

    List<SalaryComponentMasterResponse> getAllSalaryComponents();

    SuccessResponse updateSalaryComponent(UUID id, SalaryComponentMasterRequest request);
}
