package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.OrganisationDetailEntity;

import java.util.List;
import java.util.UUID;

public interface OrganisationDetailService {
    SuccessResponse createOrganisation(OrganisationDetailRequest request);

    List<OrganisationDetailResponse> getAllOrganisations();

    SuccessResponse updateOrganisation(UUID id, OrganisationDetailRequest request);

    OrganisationDetailResponse getOrganisationById(UUID id);
}
