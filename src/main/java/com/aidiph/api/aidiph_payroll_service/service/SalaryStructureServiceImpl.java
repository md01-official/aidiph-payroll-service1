package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryStructureRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryStructureResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.SalaryStructureEntity;
import com.aidiph.api.aidiph_payroll_service.exception.InvalidInputException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceAlreadyExistsException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceNotFoundException;
import com.aidiph.api.aidiph_payroll_service.mapper.SalaryStructureMapper;
import com.aidiph.api.aidiph_payroll_service.repository.OrganisationDetailRepository;
import com.aidiph.api.aidiph_payroll_service.repository.SalaryStructureRepository;
import com.aidiph.api.aidiph_payroll_service.utils.MessageSourceUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SalaryStructureServiceImpl implements SalaryStructureService {

        private final SalaryStructureRepository repository;
        private final SalaryStructureMapper mapper;
        private final OrganisationDetailRepository organisationDetailRepository;

        @Override
        public SuccessResponse createSalaryStructure(SalaryStructureRequest request) {
            log.info("Creating salary structure with code: {}", request.getStructureCode());

            if (repository.existsByStructureCode(request.getStructureCode())) {
                throw new ResourceAlreadyExistsException("Structure code already exists: " + request.getStructureCode());
            }

            if (!request.getCin().matches("^[A-Z0-9]{21}$")) {
                throw new InvalidInputException("Invalid CIN format. It must be 21 uppercase alphanumeric characters.");
            }

            if (request.getEffectiveTo() != null && request.getEffectiveFrom().isAfter(request.getEffectiveTo())) {
                throw new InvalidInputException("Effective To date must be after Effective From date.");
            }
            if (!organisationDetailRepository.existsByCin(request.getCin())) {
                throw new ResourceNotFoundException("No Organisation found with CIN: " + request.getCin());
            }

            SalaryStructureEntity entity = mapper.toEntity(request);
            repository.save(entity);

            return SuccessResponse.builder()
                    .message(MessageSourceUtils.getMessage("salary.structure.created"))
                    .build();
        }

        @Override
        public SalaryStructureResponse getSalaryStructureById(UUID id) {
            log.info("Fetching salary structure by ID: {}", id);

            SalaryStructureEntity entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            MessageSourceUtils.getMessage("salary.structure.not.found", new Object[]{id})
                    ));

            return mapper.toResponse(entity);
        }

        @Override
        public List<SalaryStructureResponse> getAllSalaryStructures() {
            log.info("Fetching all salary structures");

            List<SalaryStructureEntity> structures = repository.findAll();

            if (structures.isEmpty()) {
                throw new ResourceNotFoundException(MessageSourceUtils.getMessage("salary.structure.not.found"));
            }

            return structures.stream()
                    .map(mapper::toResponse)
                    .collect(Collectors.toList());
        }

        @Override
        public SuccessResponse updateSalaryStructure(UUID id, SalaryStructureRequest request) {
            log.info("Updating salary structure with ID: {}", id);

            if (!organisationDetailRepository.existsByCin(request.getCin())) {
                throw new ResourceNotFoundException("No Organisation found with CIN: " + request.getCin());
            }

            SalaryStructureEntity entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary Structure not found with ID: " + id));

            if (request.getStructureName() != null) entity.setStructureName(request.getStructureName());
            if (request.getAuthSignatoryDesignation() != null) entity.setAuthSignatoryDesignation(request.getAuthSignatoryDesignation());
            if (request.getCin() != null) entity.setCin(request.getCin());
            if (request.getStructureCode() != null) entity.setStructureCode(request.getStructureCode());
            if (request.getDescription() != null) entity.setDescription(request.getDescription());
            if (request.getMinCtc() != null) entity.setMinCtc(request.getMinCtc());
            if (request.getMaxCtc() != null) entity.setMaxCtc(request.getMaxCtc());
            if (request.getEffectiveFrom() != null) entity.setEffectiveFrom(request.getEffectiveFrom());
            if (request.getEffectiveTo() != null) entity.setEffectiveTo(request.getEffectiveTo());
            if (request.getIsDefault() != null) entity.setIsDefault(request.getIsDefault());

            repository.save(entity);

            return SuccessResponse.builder()
                    .message(MessageSourceUtils.getMessage("salary.structure.updated"))
                    .build();
        }
}
