package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryStructureRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryStructureResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface SalaryStructureService {
    SuccessResponse createSalaryStructure(@Valid SalaryStructureRequest request);

    SalaryStructureResponse getSalaryStructureById(UUID id);

    List<SalaryStructureResponse> getAllSalaryStructures();

    SuccessResponse updateSalaryStructure(UUID id, @Valid SalaryStructureRequest request);
}
