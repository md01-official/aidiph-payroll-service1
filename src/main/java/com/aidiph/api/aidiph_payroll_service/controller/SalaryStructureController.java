package com.aidiph.api.aidiph_payroll_service.controller;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryStructureRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryStructureResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.service.SalaryStructureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payroll-service/salary-structures")
@RequiredArgsConstructor
@Slf4j
public class SalaryStructureController {

    private final SalaryStructureService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse addSalaryStructure(@Valid @RequestBody SalaryStructureRequest request) {
        log.info("Adding salary structure with code: {}", request.getStructureCode());
        return service.createSalaryStructure(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalaryStructureResponse getSalaryStructureById(@PathVariable UUID id) {
        log.info("Fetching salary structure for ID: {}", id);
        return service.getSalaryStructureById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SalaryStructureResponse> getAllSalaryStructures() {
        log.info("Fetching all salary structures");
        return service.getAllSalaryStructures();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse updateSalaryStructureById(@PathVariable UUID id, @Valid @RequestBody SalaryStructureRequest request) {
        log.info("Updating salary structure for ID: {}", id);
        return service.updateSalaryStructure(id, request);
    }
}
