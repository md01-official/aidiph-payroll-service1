package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryStructureComponentRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryStructureComponentResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface SalaryStructureComponentService {
    SuccessResponse createSalaryComponent(SalaryStructureComponentRequest request);

    SalaryStructureComponentResponse getSalaryComponentById(UUID id);

    List<SalaryStructureComponentResponse> getAllSalaryComponents();

    List<SalaryStructureComponentResponse> getComponentsByStructureCode(String structureCode);

    SuccessResponse updateSalaryComponent(UUID id, SalaryStructureComponentRequest request);
}
