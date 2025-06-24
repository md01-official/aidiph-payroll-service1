package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDepartmentRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationDepartmentResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.OrganisationDepartmentEntity;
import com.aidiph.api.aidiph_payroll_service.exception.InvalidInputException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceAlreadyExistsException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceNotFoundException;
import com.aidiph.api.aidiph_payroll_service.mapper.OrganisationDepartmentMapper;
import com.aidiph.api.aidiph_payroll_service.repository.OrganisationDepartmentRepository;
import com.aidiph.api.aidiph_payroll_service.repository.OrganisationDetailRepository;
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
public class OrganisationDepartmentServiceImpl implements OrganisationDepartmentService {

    private final OrganisationDepartmentRepository repository;
    private final OrganisationDepartmentMapper mapper;
    private final OrganisationDetailRepository organisationDetailRepository;
    @Override
    public SuccessResponse createDepartment(OrganisationDepartmentRequest request) {
        log.info("Creating department with deptCode: {}", request.getDeptCode());

        if (repository.existsByDeptCode(request.getDeptCode())) {
            throw new ResourceAlreadyExistsException("Department code already exists: " + request.getDeptCode());
        }
        String cin = request.getCin().toUpperCase();

        if (!cin.matches("^[A-Z0-9]{21}$")) {
            throw new InvalidInputException("Invalid CIN format. It must be exactly 21 uppercase alphanumeric characters.");
        }

        if (!organisationDetailRepository.existsByCin(cin)) {
            throw new ResourceNotFoundException("No Organisation found with CIN: " + cin);
        }

        OrganisationDepartmentEntity entity = mapper.toEntity(request);
        repository.save(entity);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("department.is.created"))
                .build();
    }

    @Override
    public OrganisationDepartmentResponse getDepartmentById(UUID id) {
        log.info("Fetching department with ID: {}", id);

        OrganisationDepartmentEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        MessageSourceUtils.getMessage("department.not.found", new Object[]{id})
                ));

        return mapper.toOrganisationDepartmentResponse(entity);
    }

    @Override
    public List<OrganisationDepartmentResponse> getAllDepartments() {
        log.info("Fetching all departments");

        List<OrganisationDepartmentEntity> entities = repository.findAll();
        if (entities.isEmpty()) {
            throw new ResourceNotFoundException(MessageSourceUtils.getMessage("department.not.found"));
        }

        return entities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessResponse updateDepartment(UUID id, OrganisationDepartmentRequest request) {
        OrganisationDepartmentEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageSourceUtils.getMessage("department.not.found")));;
        if (repository.existsByDeptCode(request.getDeptCode())) {
            throw new ResourceAlreadyExistsException("Department code already exists: " + request.getDeptCode());
        }
        String cin = request.getCin().toUpperCase();

        if (!cin.matches("^[A-Z0-9]{21}$")) {
            throw new InvalidInputException("Invalid CIN format. It must be exactly 21 uppercase alphanumeric characters.");
        }

        if (!organisationDetailRepository.existsByCin(cin)) {
            throw new ResourceNotFoundException("No Organisation found with CIN: " + cin);
        }
        if(entity.getTypeName() != null) entity.setTypeName(request.getTypeName());
        if(entity.getTypeCode() != null) entity.setTypeCode(request.getTypeCode());
        if(entity.getDescription() != null) entity.setDescription(request.getDescription());
        if(entity.getAuthSignatoryDesignation() != null) entity.setAuthSignatoryDesignation(request.getAuthSignatoryDesignation());
        if(entity.getCin() != null) entity.setCin(request.getCin());
        if(entity.getDeptCode() != null) entity.setDeptCode(request.getDeptCode());
        if(entity.getDeptName() != null) entity.setDeptName(request.getDeptName());
        if(entity.getParentDeptTypeCode() != null) entity.setParentDeptTypeCode(request.getParentDeptTypeCode());
        if(entity.getParentDeptCode() != null) entity.setParentDeptCode(request.getParentDeptCode());
        if(entity.getCostCenterCode() != null) entity.setCostCenterCode(request.getCostCenterCode());
        if(entity.getDeptDescription() != null) entity.setDeptDescription(request.getDeptDescription());

        repository.save(entity);
        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("department.is.updated")).build();
    }
}
