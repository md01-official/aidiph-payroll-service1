package com.aidiph.api.aidiph_payroll_service.controller;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.service.OrganisationDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payroll-service/organisations")
@RequiredArgsConstructor
@Slf4j
public class OrganisationDetailController {
    private final OrganisationDetailService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse addOrganisation(@Valid @RequestBody OrganisationDetailRequest request) {
        log.info("Adding  organisation detail for organisation ID: {}");
        return service.createOrganisation(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganisationDetailResponse getOrganisationDetailById(UUID id) {
        log.info("Fetching organisation detail for employee ID: {}", id);
        return service.getOrganisationById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrganisationDetailResponse> getAllOrganisationDetail() {
        log.info("Fetching all organisation details");
        return service.getAllOrganisations();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse updateOrganisationDetailById(UUID id, @Valid @RequestBody OrganisationDetailRequest request){
        log.info("Updating employee personal detail for employee ID: {}", id);
        return service.updateOrganisation(id, request);
    }
}
