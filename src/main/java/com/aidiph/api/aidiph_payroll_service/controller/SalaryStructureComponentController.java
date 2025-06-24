package com.aidiph.api.aidiph_payroll_service.controller;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryStructureComponentRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryStructureComponentResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.service.SalaryStructureComponentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payroll-service/salary-structure-components")
@RequiredArgsConstructor
@Slf4j
public class SalaryStructureComponentController {

    private final SalaryStructureComponentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse addSalaryComponent(@Valid @RequestBody SalaryStructureComponentRequest request) {
        log.info("Adding salary component: {}", request.getComponentCode());
        return service.createSalaryComponent(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalaryStructureComponentResponse getSalaryComponentById(@PathVariable UUID id) {
        log.info("Fetching salary component details for ID: {}", id);
        return service.getSalaryComponentById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SalaryStructureComponentResponse> getAllSalaryComponents() {
        log.info("Fetching all salary components");
        return service.getAllSalaryComponents();
    }

    @GetMapping("/by-structure/{structureCode}")
    @ResponseStatus(HttpStatus.OK)
    public List<SalaryStructureComponentResponse> getComponentsByStructure(@PathVariable String structureCode) {
        log.info("Fetching salary components for structure code: {}", structureCode);
        return service.getComponentsByStructureCode(structureCode);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse updateSalaryComponent(@PathVariable UUID id,
                                                 @Valid @RequestBody SalaryStructureComponentRequest request) {
        log.info("Updating salary component ID: {}", id);
        return service.updateSalaryComponent(id, request);
    }
}
