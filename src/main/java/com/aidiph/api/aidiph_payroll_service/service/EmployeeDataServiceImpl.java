package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeeDataRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeeDataResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeeDataEntity;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceNotFoundException;
import com.aidiph.api.aidiph_payroll_service.mapper.EmployeeDataMapper;
import com.aidiph.api.aidiph_payroll_service.repository.*;
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
public class EmployeeDataServiceImpl implements EmployeeDataService {

    private final EmployeeDataRepository repository;
    private final EmployeeDataMapper mapper;
    private final EmployeePersonalDetailRepo personalDetailRepo;
    private final OrganisationDetailRepository organisationDetailRepository;
    private final OrganisationLocationRepository locationRepository;
    private final OrganisationDepartmentRepository departmentRepository;

    @Override
    public SuccessResponse createEmployee(EmployeeDataRequest request) {
        log.info("Creating employee: {} {}", request.getFirstName(), request.getLastName());

        boolean employeeExists = personalDetailRepo.existsById(request.getEmployeeId());
        if (!employeeExists) {
            throw new ResourceNotFoundException("No employee found with ID: " + request.getEmployeeId());
        }
        boolean organisationExists = organisationDetailRepository.existsByCin(request.getCin());
        if (!organisationExists) {
            throw new ResourceNotFoundException("No organisation found with CIN: " + request.getCin());
        }

        boolean departmentExists = departmentRepository.existsByDeptCode(request.getDeptCode());
        if (!departmentExists) {
            throw new ResourceNotFoundException("No department found with deptCode: " + request.getDeptCode());
        }

        boolean locationExists = locationRepository.existsByLocationCode(request.getWorkLocationCode());
        if (!locationExists) {
            throw new ResourceNotFoundException("No location found with workLocationCode: " + request.getWorkLocationCode());
        }
        EmployeeDataEntity entity = mapper.toEntity(request);
        repository.save(entity);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("employee.data.created"))
                .build();
    }

    @Override
    public EmployeeDataResponse getEmployeeById(UUID id) {
        log.info("Fetching employee details for ID: {}", id);
        EmployeeDataEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                MessageSourceUtils.getMessage("employee.data.not.found", new Object[]{id})));
        EmployeeDataResponse response = mapper.toEmployeeDataResponse(entity);
        return response;
    }

    @Override
    public List<EmployeeDataResponse> getAllEmployees() {
        log.info("Fetching all employees");
        List<EmployeeDataEntity> employees = repository.findAll();

        if (employees.isEmpty()) {
            throw new ResourceNotFoundException(MessageSourceUtils.getMessage("employee.data.not.found"));
        }
        return employees.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessResponse updateEmployee(UUID id, EmployeeDataRequest request) {
        log.info("Updating employee with ID: {}", id);

        EmployeeDataEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

        if (request.getEmployeeId() != null && !personalDetailRepo.existsById(request.getEmployeeId())) {
            throw new ResourceNotFoundException("No employee found with ID: " + request.getEmployeeId());
        }
        if (request.getCin() != null && !organisationDetailRepository.existsByCin(request.getCin())) {
            throw new ResourceNotFoundException("No organisation found with CIN: " + request.getCin());
        }

        if (request.getDeptCode() != null && !departmentRepository.existsByDeptCode(request.getDeptCode())) {
            throw new ResourceNotFoundException("No department found with deptCode: " + request.getDeptCode());
        }
        if (request.getWorkLocationCode() != null && !locationRepository.existsByLocationCode(request.getWorkLocationCode())) {
            throw new ResourceNotFoundException("No location found with workLocationCode: " + request.getWorkLocationCode());
        }

        if (request.getTypeName() != null) entity.setTypeName(request.getTypeName());
        if (request.getFirstName() != null) entity.setFirstName(request.getFirstName());
        if (request.getLastName() != null) entity.setLastName(request.getLastName());
        if (request.getPersonalEmail() != null) entity.setPersonalEmail(request.getPersonalEmail());
        if (request.getMobileNumber() != null) entity.setMobileNumber(request.getMobileNumber());
        if (request.getCin() != null) entity.setCin(request.getCin());
        if (request.getConfirmationDate() != null) entity.setConfirmationDate(request.getConfirmationDate());
        if (request.getContractEndDate() != null) entity.setContractEndDate(request.getContractEndDate());
        if (request.getProbationEndDate() != null) entity.setProbationEndDate(request.getProbationEndDate());
        if (request.getAuthSignatoryDesignation() != null)
            entity.setAuthSignatoryDesignation(request.getAuthSignatoryDesignation());
        if (request.getDateJoined() != null) entity.setDateJoined(request.getDateJoined());
        if (request.getDeptCode() != null) entity.setDeptCode(request.getDeptCode());
        if (request.getDateOfBirth() != null) entity.setDateOfBirth(request.getDateOfBirth());
        if (request.getDisplayName() != null) entity.setDisplayName(request.getDisplayName());
        if (request.getDescription() != null) entity.setDescription(request.getDescription());
        if (request.getDeptTypeCode() != null) entity.setDeptTypeCode(request.getDeptTypeCode());
        if (request.getEmergencyContactName() != null)
            entity.setEmergencyContactName(request.getEmergencyContactName());
        if (request.getEmergencyContactNumber() != null)
            entity.setEmergencyContactNumber(request.getEmergencyContactNumber());
        if (request.getEmergencyContactRelationship() != null)
            entity.setEmergencyContactRelationship(request.getEmergencyContactRelationship());
        if (request.getGender() != null) entity.setGender(request.getGender());
        if (request.getMiddleName() != null) entity.setMiddleName(request.getMiddleName());
        if (request.getTitle() != null) entity.setTitle(request.getTitle());
        if (request.getTitleCode() != null) entity.setTitleCode(request.getTitleCode());
        if (request.getTitleDescription() != null) entity.setTitleDescription(request.getTitleDescription());
        if (request.getGradeLevel() != null) entity.setGradeLevel(request.getGradeLevel());
        if (request.getReportingManagerFirstName() != null)
            entity.setReportingManagerFirstName(request.getReportingManagerFirstName());
        if (request.getReportingManagerEmployeeNumber() != null)
            entity.setReportingManagerEmployeeNumber(request.getReportingManagerEmployeeNumber());
        if (request.getNoticePeriodDays() != null) entity.setNoticePeriodDays(request.getNoticePeriodDays());
        if (request.getWorkLocationCity() != null) entity.setWorkLocationCity(request.getWorkLocationCity());
        if (request.getWorkLocationCode() != null) entity.setWorkLocationCode(request.getWorkLocationCode());

        repository.save(entity);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("employee.data.updated"))
                .build();
    }

}