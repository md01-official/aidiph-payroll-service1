package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryComponentMasterRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryComponentMasterResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.SalaryComponentMasterEntity;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceAlreadyExistsException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceNotFoundException;
import com.aidiph.api.aidiph_payroll_service.mapper.SalaryComponentMasterMapper;
import com.aidiph.api.aidiph_payroll_service.repository.OrganisationDetailRepository;
import com.aidiph.api.aidiph_payroll_service.repository.SalaryComponentMasterRepository;
import com.aidiph.api.aidiph_payroll_service.utils.MessageSourceUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalaryComponentMasterServiceImpl implements SalaryComponentMasterService{

        private final SalaryComponentMasterRepository repository;
        private final SalaryComponentMasterMapper mapper;
        private final OrganisationDetailRepository organisationDetailRepository;

        @Override
        public SuccessResponse createSalaryComponent(SalaryComponentMasterRequest request) {
            log.info("Creating salary component with code: {}", request.getComponentCode());

            if (repository.existsByComponentCode(request.getComponentCode())) {
                throw new ResourceAlreadyExistsException("Component code already exists: " + request.getComponentCode());
            }

            if (!request.getCin().matches("^[A-Z0-9]{21}$")) {
                throw new IllegalArgumentException("Invalid CIN format. It must be 21 uppercase alphanumeric characters.");
            }
            if (!organisationDetailRepository.existsByCin(request.getCin())) {
                throw new ResourceNotFoundException("No Organisation found with CIN: " + request.getCin());
            }

            SalaryComponentMasterEntity entity = mapper.toEntity(request);
            repository.save(entity);

            return SuccessResponse.builder()
                    .message(MessageSourceUtils.getMessage("salary.component.created"))
                    .build();
        }

        @Override
        public SalaryComponentMasterResponse getSalaryComponentById(UUID id) {
            log.info("Fetching salary component by ID: {}", id);

            SalaryComponentMasterEntity entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            MessageSourceUtils.getMessage("salary.component.not.found", new Object[]{id})
                    ));

            return mapper.toResponse(entity);
        }

        @Override
        public List<SalaryComponentMasterResponse> getAllSalaryComponents() {
            log.info("Fetching all salary components");

            List<SalaryComponentMasterEntity> components = repository.findAll();

            if (components.isEmpty()) {
                throw new ResourceNotFoundException(MessageSourceUtils.getMessage("salary.component.not.found"));
            }

            return components.stream()
                    .map(mapper::toResponse)
                    .collect(Collectors.toList());
        }
        @Override
        public SuccessResponse updateSalaryComponent(UUID id, SalaryComponentMasterRequest request) {
            log.info("Updating salary component with ID: {}", id);

            SalaryComponentMasterEntity entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(MessageSourceUtils.getMessage("salary.component.not.found") + id));

            if (!organisationDetailRepository.existsByCin(request.getCin())) {
                throw new ResourceNotFoundException("No Organisation found with CIN: " + request.getCin());
            }

            if (request.getComponentName() != null) entity.setComponentName(request.getComponentName());
            if (request.getAuthSignatoryDesignation() != null)
                entity.setAuthSignatoryDesignation(request.getAuthSignatoryDesignation());
            if (request.getComponentCategory() != null) entity.setComponentCategory(request.getComponentCategory());
            if (request.getComponentType() != null) entity.setComponentType(request.getComponentType());
            if (request.getCalculationType() != null) entity.setCalculationType(request.getCalculationType());
            if (request.getCalculationBasis() != null) entity.setCalculationBasis(request.getCalculationBasis());
            if (request.getCalculationFormula() != null) entity.setCalculationFormula(request.getCalculationFormula());
            if (request.getCalculationFrequency() != null)
                entity.setCalculationFrequency(request.getCalculationFrequency());
            if (request.getIsTaxable() != null) entity.setIsTaxable(request.getIsTaxable());
            if (request.getConsiderForCtc() != null) entity.setConsiderForCtc(request.getConsiderForCtc());
            if (request.getConsiderForEsi() != null) entity.setConsiderForEsi(request.getConsiderForEsi());
            if (request.getConsiderForPf() != null) entity.setConsiderForPf(request.getConsiderForPf());
            if (request.getConsiderForBonus() != null) entity.setConsiderForBonus(request.getConsiderForBonus());
            if (request.getMinValue() != null) entity.setMinValue(request.getMinValue());
            if (request.getMaxValue() != null) entity.setMaxValue(request.getMaxValue());
            if (request.getRoundingFactor() >= 0) entity.setRoundingFactor(request.getRoundingFactor());
            if (request.getPrintName() != null) entity.setPrintName(request.getPrintName());
            if (request.getDescription() != null) entity.setDescription(request.getDescription());

            repository.save(entity);

            return SuccessResponse.builder()
                    .message(MessageSourceUtils.getMessage("salary.component.updated"))
                    .build();
        }
    }
