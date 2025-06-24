package com.aidiph.api.aidiph_payroll_service.controller;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationLocationRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationLocationResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.OrganisationLocationEntity;
import com.aidiph.api.aidiph_payroll_service.service.OrganisationLocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payroll-service/organisation-location")
@RequiredArgsConstructor
@Slf4j
public class OrganisationLocationController {
    private final OrganisationLocationService organisationLocationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse addOrganisationLocation(@Valid @RequestBody OrganisationLocationRequest request) {
        log.info("Adding  organisation location detail for organisation ID: {}");
        return organisationLocationService.createOrganisationLocation(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganisationLocationResponse getOrganisationLocation(UUID id){
        log.info("Fetching organisation Location detail for organisation ID: {}", id);
        return organisationLocationService.getOrganisationLocationById(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrganisationLocationEntity> getAllOrganisationLocation(){
        log.info("Fetching all organisation location details");
        return organisationLocationService.getAllOrganisationLocation();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse updateOrganisationLocation(UUID id, @Valid @RequestBody OrganisationLocationRequest request){
        log.info("updating organisation location details: {}", id);
        return organisationLocationService.updateOrganisationLocation(id, request);
    }

}