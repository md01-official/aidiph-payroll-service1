package com.aidiph.api.aidiph_payroll_service.controller;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDepartmentRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationDepartmentResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.service.OrganisationDepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payroll-service/organisation-department")
@RequiredArgsConstructor
@Slf4j
public class OrganisationDepartmentController {

    private final OrganisationDepartmentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse addOrganisationDepartment(@Valid @RequestBody OrganisationDepartmentRequest request) {
        log.info("Adding organisation department: {}", request.getDeptName());
        return service.createDepartment(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganisationDepartmentResponse getOrganisationDepartmentById(@PathVariable UUID id) {
        log.info("Fetching organisation department details for department ID: {}", id);
        return service.getDepartmentById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrganisationDepartmentResponse> getAllOrganisationDepartments() {
        log.info("Fetching all organisation department details");
        return service.getAllDepartments();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse updateOrganisationDepartmentById(@PathVariable UUID id, @Valid @RequestBody OrganisationDepartmentRequest request) {
        log.info("Updating organisation department for department ID: {}", id);
        return service.updateDepartment(id, request);
    }
}