package com.aidiph.api.aidiph_payroll_service.controller;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryComponentMasterRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryComponentMasterResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.service.SalaryComponentMasterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payroll-service/salary-components")
@RequiredArgsConstructor
@Slf4j
public class SalaryComponentMasterController {

    private final SalaryComponentMasterService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse createSalaryComponent(@Valid @RequestBody SalaryComponentMasterRequest request) {
        return service.createSalaryComponent(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalaryComponentMasterResponse getSalaryComponentById(@PathVariable UUID id) {
        return service.getSalaryComponentById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SalaryComponentMasterResponse> getAllSalaryComponents() {

        return service.getAllSalaryComponents();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse updateSalaryComponent(@PathVariable UUID id, @RequestBody SalaryComponentMasterRequest request) {
        return service.updateSalaryComponent(id, request);
    }
}
