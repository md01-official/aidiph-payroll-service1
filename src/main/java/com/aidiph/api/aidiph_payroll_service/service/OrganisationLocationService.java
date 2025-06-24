package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationLocationRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationLocationResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.OrganisationLocationEntity;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface OrganisationLocationService {
    SuccessResponse createOrganisationLocation(@Valid OrganisationLocationRequest request);

    OrganisationLocationResponse getOrganisationLocationById(UUID id);

    List<OrganisationLocationEntity> getAllOrganisationLocation();

    SuccessResponse updateOrganisationLocation(UUID id, @Valid OrganisationLocationRequest request);
}
