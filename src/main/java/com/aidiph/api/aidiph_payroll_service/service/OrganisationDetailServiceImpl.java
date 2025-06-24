package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.OrganisationDetailEntity;
import com.aidiph.api.aidiph_payroll_service.exception.InvalidInputException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceAlreadyExistsException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceNotFoundException;
import com.aidiph.api.aidiph_payroll_service.mapper.OrganisationDetailMapper;
import com.aidiph.api.aidiph_payroll_service.repository.OrganisationDetailRepository;
import com.aidiph.api.aidiph_payroll_service.utils.MessageSourceUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrganisationDetailServiceImpl implements OrganisationDetailService {

    private final OrganisationDetailRepository organisationDetailRepository;
    private final OrganisationDetailMapper organisationDetailMapper;

    @Override
    public SuccessResponse createOrganisation(OrganisationDetailRequest request) {
        if (organisationDetailRepository.existsByCin(request.getCin())) {
            throw new ResourceAlreadyExistsException("Organisation with CIN '" + request.getCin() + "' already exists.");
        }

        if (request.getPan() != null && !request.getPan().matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
            throw new IllegalArgumentException("Invalid PAN format: " + request.getPan());
        }
        if (request.getAuthSignatoryEmail() != null && !request.getAuthSignatoryEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid Email Format");
        }

        if (request.getIfscCode() != null && !request.getIfscCode().matches("^[A-Z]{4}0[A-Z0-9]{6}$")) {
            throw new IllegalArgumentException("Invalid IFSC Code: " + request.getIfscCode());
        }

        if (request.getComplianceCode() != null && !request.getComplianceCode().matches("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}[Z]{1}[0-9A-Z]{1}$")) {
            throw new IllegalArgumentException("Invalid GSTIN format: " + request.getComplianceCode());
        }

        if (request.getAccountNumber() != null && request.getAccountNumber().length() < 9) {
            throw new IllegalArgumentException("Invalid Bank Account Number");
        }

        OrganisationDetailEntity entity = organisationDetailMapper.toEntity(request);
        organisationDetailRepository.save(entity);
        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("organisation.is.created"))
                .build();
    }

    @Override
    public OrganisationDetailResponse getOrganisationById(UUID id) {
        OrganisationDetailEntity entity = organisationDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                MessageSourceUtils.getMessage("organisation.not.found", new Object[]{id})
        ));
        return organisationDetailMapper.toOrganisationDetailResponse(entity, new OrganisationDetailResponse());
    }

    @Override
    public List<OrganisationDetailResponse> getAllOrganisations() {
        List<OrganisationDetailEntity> entities = organisationDetailRepository.findAll();
        if (entities.isEmpty()) {
            throw new ResourceNotFoundException(MessageSourceUtils.getMessage("organisation.not.found"));
        }
        return entities.stream()
                .map(organisationDetailMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessResponse updateOrganisation(UUID id, OrganisationDetailRequest request) {
        OrganisationDetailEntity organisation = organisationDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageSourceUtils.getMessage("organisation.not.found")));

        if (organisationDetailRepository.existsByCin(request.getCin())) {
            throw new ResourceAlreadyExistsException("Organisation with CIN '" + request.getCin() + "' already exists.");
        }

        if (request.getAuthSignatoryEmail() != null && !request.getAuthSignatoryEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new InvalidInputException("Invalid Email Format");
        }

        if (request.getIfscCode() != null && !request.getIfscCode().matches("^[A-Z]{4}0[A-Z0-9]{6}$")) {
            throw new InvalidInputException("Invalid IFSC Code: " + request.getIfscCode());
        }
        if (request.getComplianceCode() != null && !request.getComplianceCode().matches("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}[Z]{1}[0-9A-Z]{1}$")) {
            throw new InvalidInputException("Invalid GSTIN format: " + request.getComplianceCode());
        }

        if (request.getAccountNumber() != null && request.getAccountNumber().length() < 9) {
            throw new InvalidInputException("Invalid Bank Account Number");
        }
        if (request.getLegalEntityName() != null) organisation.setLegalEntityName(request.getLegalEntityName());
        if (request.getAuthSignatoryName() != null) organisation.setAuthSignatoryName(request.getAuthSignatoryName());
        if (request.getAuthSignatoryDesignation() != null)
            organisation.setAuthSignatoryDesignation(request.getAuthSignatoryDesignation());
        if (request.getAuthSignatoryEmail() != null)
            organisation.setAuthSignatoryEmail(request.getAuthSignatoryEmail());
        if (request.getAuthSignatoryFatherName() != null)
            organisation.setAuthSignatoryFatherName(request.getAuthSignatoryFatherName());
        if (request.getCorporationDate() != null) organisation.setCorporationDate(request.getCorporationDate());
        if (request.getCin() != null) organisation.setCin(request.getCin());
        if (request.getBankType() != null) organisation.setBankType(request.getBankType());
        if (request.getBankName() != null) organisation.setBankName(request.getBankName());
        if (request.getBankCode() != null) organisation.setBankCode(request.getBankCode());
        if (request.getSwiftCode() != null) organisation.setSwiftCode(request.getSwiftCode());
        if (request.getAccountNumber() != null) organisation.setAccountNumber(request.getAccountNumber());
        if (request.getIfscCode() != null) organisation.setIfscCode(request.getIfscCode());
        if (request.getBranchName() != null) organisation.setBranchName(request.getBranchName());
        if (request.getNameOnAccount() != null) organisation.setNameOnAccount(request.getNameOnAccount());
        if (request.getPan() != null) organisation.setPan(request.getPan());
        if (request.getTan() != null) organisation.setTan(request.getTan());
        if (request.getTanCircleNumber() != null) organisation.setTanCircleNumber(request.getTanCircleNumber());
        if (request.getCorporateIncomeTaxLocations() != null)
            organisation.setCorporateIncomeTaxLocations(request.getCorporateIncomeTaxLocations());
        if (request.getComplianceCode() != null) organisation.setComplianceCode(request.getComplianceCode());
        if (request.getPfEstablishmentId() != null) organisation.setPfEstablishmentId(request.getPfEstablishmentId());
        if (request.getPfNumber() != null) organisation.setPfNumber(request.getPfNumber());
        if (request.getPfRegistrationDate() != null)
            organisation.setPfRegistrationDate(request.getPfRegistrationDate());
        if (request.getEsiNumber() != null) organisation.setEsiNumber(request.getEsiNumber());
        if (request.getEsiRegistrationDate() != null)
            organisation.setEsiRegistrationDate(request.getEsiRegistrationDate());
        if (request.getPtEstablishmentId() != null) organisation.setPtEstablishmentId(request.getPtEstablishmentId());
        if (request.getPtNumber() != null) organisation.setPtNumber(request.getPtNumber());
        if (request.getPtRegistrationDate() != null)
            organisation.setPtRegistrationDate(request.getPtRegistrationDate());
        if (request.getLwfEstablishmentId() != null)
            organisation.setLwfEstablishmentId(request.getLwfEstablishmentId());
        if (request.getLwfRegistrationDate() != null)
            organisation.setLwfRegistrationDate(request.getLwfRegistrationDate());

        organisationDetailRepository.save(organisation);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("organisation.updated"))
                .build();
    }
}
