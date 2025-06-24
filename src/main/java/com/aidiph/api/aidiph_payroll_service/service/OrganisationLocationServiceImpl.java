package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationLocationRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationLocationResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.OrganisationLocationEntity;
import com.aidiph.api.aidiph_payroll_service.exception.InvalidInputException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceAlreadyExistsException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceNotFoundException;
import com.aidiph.api.aidiph_payroll_service.mapper.OrganisationLocationMapper;
import com.aidiph.api.aidiph_payroll_service.repository.OrganisationDetailRepository;
import com.aidiph.api.aidiph_payroll_service.repository.OrganisationLocationRepository;
import com.aidiph.api.aidiph_payroll_service.utils.MessageSourceUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganisationLocationServiceImpl implements OrganisationLocationService {
    private final OrganisationLocationRepository organisationLocationRepository;
    private final OrganisationLocationMapper organisationLocationMapper;
    private final OrganisationDetailRepository organisationDetailRepository;

    @Override
    public SuccessResponse createOrganisationLocation(OrganisationLocationRequest request) {

        boolean organisationExists = organisationDetailRepository.existsByCin(request.getCin());
        if (!organisationExists) {
            throw new ResourceNotFoundException("No Organisation found with CIN: " + request.getCin());
        }
        if (request.getGstin() != null && !request.getGstin().matches("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}[Z]{1}[0-9A-Z]{1}$")) {
            throw new InvalidInputException("Invalid GSTIN format: " + request.getGstin());
        }

        if (organisationLocationRepository.existsByLocationCode(request.getLocationCode())) {
            throw new ResourceAlreadyExistsException("Location Code already exists: " + request.getLocationCode());
        }

        if (organisationLocationRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Email is already in use: " + request.getEmail());
        }

        if (request.getPincode() <= 0 || request.getPincode().toString().length() < 5) {
            throw new InvalidInputException("Invalid Pincode: " + request.getPincode());
        }

        if (String.valueOf(request.getPhone()).length() < 10) {
            throw new InvalidInputException("Invalid Phone Number: " + request.getPhone());
        }
        OrganisationLocationEntity entity = organisationLocationMapper.toEntity(request);
        organisationLocationRepository.save(entity);
        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("organisation.location.is.created"))
                .build();
    }

    @Override
    public OrganisationLocationResponse getOrganisationLocationById(UUID id) {
        OrganisationLocationEntity entity = organisationLocationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                MessageSourceUtils.getMessage("organisation.location.not.found", new Object[]{id})
        ));
        OrganisationLocationResponse response = organisationLocationMapper.toOrganisationLocationResponse(entity);
        return response;
    }

    @Override
    public List<OrganisationLocationEntity> getAllOrganisationLocation() {
        List<OrganisationLocationEntity> entities = organisationLocationRepository.findAll();
        if (entities.isEmpty()) {
            throw new ResourceNotFoundException(MessageSourceUtils.getMessage("organisation.location.not.found"));
        }
        return entities.stream()
                .map(organisationLocationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessResponse updateOrganisationLocation(UUID id, OrganisationLocationRequest request) {
        OrganisationLocationEntity organisation = organisationLocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageSourceUtils.getMessage("organisation.location.not.found")));

        boolean organisationExists = organisationDetailRepository.existsByCin(request.getCin());
        if (!organisationExists) {
            throw new ResourceNotFoundException("No Organisation found with CIN: " + request.getCin());
        }
        if (request.getGstin() != null && !request.getGstin().matches("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}[Z]{1}[0-9A-Z]{1}$")) {
            throw new IllegalArgumentException("Invalid GSTIN format: " + request.getGstin());
        }

        if (organisationLocationRepository.existsByLocationCode(request.getLocationCode())) {
            throw new ResourceAlreadyExistsException("Location Code already exists: " + request.getLocationCode());
        }

        if (organisationLocationRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Email is already in use: " + request.getEmail());
        }

        if (request.getPincode() <= 0 || request.getPincode().toString().length() < 5) {
            throw new InvalidInputException("Invalid Pincode: " + request.getPincode());
        }

        if (String.valueOf(request.getPhone()).length() < 10) {
            throw new InvalidInputException("Invalid Phone Number: " + request.getPhone());
        }
        if (request.getCountryCode() != null) organisation.setCountryCode(request.getCountryCode());
        if (request.getCountryName() != null) organisation.setCountryName(request.getCountryName());
        if (request.getDialCode() != null) organisation.setDialCode(request.getDialCode());
        if (request.getCurrencyCode() != null) organisation.setCurrencyCode(request.getCurrencyCode());
        if (request.getAuthSignatoryDesignation() != null) organisation.setAuthSignatoryDesignation(request.getAuthSignatoryDesignation());
        if (request.getCin() != null) organisation.setCin(request.getCin());
        if (request.getStateCode() != null) organisation.setStateCode(request.getStateCode());
        if (request.getStateName() != null) organisation.setStateName(request.getStateName());
        if (request.getLocationName() != null) organisation.setLocationName(request.getLocationName());
        if (request.getLocationCode() != null) organisation.setLocationCode(request.getLocationCode());
        if (request.getIsHeadOffice() != null) organisation.setIsHeadOffice(request.getIsHeadOffice());
        if (request.getIsRegisteredOffice() != null) organisation.setIsRegisteredOffice(request.getIsRegisteredOffice());
        if (request.getIsBranch() != null) organisation.setIsBranch(request.getIsBranch());
        if (request.getAddressLine1() != null) organisation.setAddressLine1(request.getAddressLine1());
        if (request.getAddressLine2() != null) organisation.setAddressLine2(request.getAddressLine2());
        if (request.getLocality() != null) organisation.setLocality(request.getLocality());
        if (request.getCity() != null) organisation.setCity(request.getCity());
        if (request.getPincode() != null) organisation.setPincode(request.getPincode());
        if (request.getEmail() != null) organisation.setEmail(request.getEmail());
        if (request.getPhone() != null) organisation.setPhone(request.getPhone());
        if (request.getGstin() != null) organisation.setGstin(request.getGstin());

        organisationLocationRepository.save(organisation);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("organisation.location.updated"))
                .build();
    }
}
