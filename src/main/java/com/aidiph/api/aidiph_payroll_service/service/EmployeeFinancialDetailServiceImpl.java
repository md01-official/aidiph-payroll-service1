package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeeFinancialDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeeFinancialDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeeFinancialDetailEntity;
import com.aidiph.api.aidiph_payroll_service.exception.InvalidInputException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceAlreadyExistsException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceNotFoundException;
import com.aidiph.api.aidiph_payroll_service.mapper.EmployeeFinancialDetailMapper;
import com.aidiph.api.aidiph_payroll_service.repository.EmployeeFinancialDetailRepository;
import com.aidiph.api.aidiph_payroll_service.repository.EmployeePersonalDetailRepo;
import com.aidiph.api.aidiph_payroll_service.utils.MessageSourceUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EmployeeFinancialDetailServiceImpl implements EmployeeFinancialDetailService {

    private final EmployeeFinancialDetailRepository repository;
    private final EmployeeFinancialDetailMapper mapper;
    private final EmployeePersonalDetailRepo personalDetailRepo;

    private static final Set<String> VALID_BANK_TYPES = Set.of("SAVINGS", "CURRENT", "SALARY");
    private static final Set<String> VALID_ACCOUNT_TYPES = Set.of("SAVINGS", "CURRENT", "FIXED_DEPOSIT");

    @Override
    public SuccessResponse createEmployeeFinancialDetail(EmployeeFinancialDetailRequest request) {
        log.info("Creating financial details for Employee ID: {}", request.getEmployeeNumber());

        if (!personalDetailRepo.existsById(request.getEmployeeNumber())) {
            throw new ResourceNotFoundException("No employee found with ID: " + request.getEmployeeNumber());
        }

        if (repository.existsByAccountNumber(request.getAccountNumber())) {
            throw new ResourceAlreadyExistsException("Account number already exists: " + request.getAccountNumber());
        }

        if (request.getPanNumber() != null && repository.existsByPanNumber(request.getPanNumber())) {
            throw new ResourceAlreadyExistsException("PAN number already exists: " + request.getPanNumber());
        }

        if (request.getAadharNumber() != null && repository.existsByAadharNumber(request.getAadharNumber())) {
            throw new ResourceAlreadyExistsException("Aadhar number already exists: " + request.getAadharNumber());
        }

        if (!VALID_BANK_TYPES.contains(request.getBankType().toUpperCase())) {
            throw new IllegalArgumentException("Invalid bank type. Allowed: SAVINGS, CURRENT, SALARY.");
        }

        if (!VALID_ACCOUNT_TYPES.contains(request.getAccountType().toUpperCase())) {
            throw new IllegalArgumentException("Invalid account type. Allowed: SAVINGS, CURRENT, FIXED_DEPOSIT.");
        }

        if (request.getPfDetailAvailable() != null && request.getPfDetailAvailable() && request.getPfNumber() == null) {
            throw new InvalidInputException("PF Number is required when PF detail is available.");
        }
        if (request.getEsiDetailAvailable() != null && request.getEsiDetailAvailable() && request.getEmployeeEsiNumber() == null) {
            throw new InvalidInputException("ESI Number is required when ESI detail is available.");
        }
        EmployeeFinancialDetailEntity entity = mapper.toEntity(request);
        repository.save(entity);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("employee.financial.detail.created"))
                .build();
    }

    @Override
    public EmployeeFinancialDetailResponse getEmployeeFinancialDetailById(UUID id) {
        log.info("Fetching financial details for Employee ID: {}", id);

        EmployeeFinancialDetailEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        MessageSourceUtils.getMessage("employee.financial.detail.not.found", new Object[]{id})
                ));

        return mapper.toResponse(entity);
    }

    @Override
    public List<EmployeeFinancialDetailResponse> getAllEmployeeFinancialDetails() {
        log.info("Fetching all employee financial details");

        List<EmployeeFinancialDetailEntity> entities = repository.findAll();

        if (entities.isEmpty()) {
            throw new ResourceNotFoundException(MessageSourceUtils.getMessage("employee.financial.detail.not.found"));
        }

        return entities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessResponse updateEmployeeFinancialDetail(UUID id, EmployeeFinancialDetailRequest request) {
        log.info("Updating financial details for Employee ID: {}", id);

        EmployeeFinancialDetailEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        MessageSourceUtils.getMessage("employee.financial.detail.not.found", new Object[]{id})
                ));
        if (!personalDetailRepo.existsById(request.getEmployeeNumber())) {
            throw new ResourceNotFoundException("No employee found with ID: " + request.getEmployeeNumber());
        }

//        if (repository.existsByAccountNumber(request.getAccountNumber())) {
//            throw new ResourceAlreadyExistsException("Account number already exists: " + request.getAccountNumber());
//        }

//        if (request.getPanNumber() != null && repository.existsByPanNumber(request.getPanNumber())) {
//            throw new ResourceAlreadyExistsException("PAN number already exists: " + request.getPanNumber());
//        }
//
//        if (request.getAadharNumber() != null && repository.existsByAadharNumber(request.getAadharNumber())) {
//            throw new ResourceAlreadyExistsException("Aadhar number already exists: " + request.getAadharNumber());
//        }

//        if (!VALID_BANK_TYPES.contains(request.getBankType().toUpperCase())) {
//            throw new IllegalArgumentException("Invalid bank type. Allowed: SAVINGS, CURRENT, SALARY.");
//        }
//
//        if (!VALID_ACCOUNT_TYPES.contains(request.getAccountType().toUpperCase())) {
//            throw new IllegalArgumentException("Invalid account type. Allowed: SAVINGS, CURRENT, FIXED_DEPOSIT.");
//        }

        if (request.getPfDetailAvailable() != null && request.getPfDetailAvailable() && request.getPfNumber() == null) {
            throw new InvalidInputException("PF Number is required when PF detail is available.");
        }
        if (request.getEsiDetailAvailable() != null && request.getEsiDetailAvailable() && request.getEmployeeEsiNumber() == null) {
            throw new InvalidInputException("ESI Number is required when ESI detail is available.");
        }

        if (request.getEmployeeNumber()!= null) entity.setEmployeeNumber(request.getEmployeeNumber());
        if (request.getBankType() != null) entity.setBankType(request.getBankType());
        if (request.getBankCode() != null) entity.setBankCode(request.getBankCode());
        if (request.getSwiftCode() != null) entity.setSwiftCode(request.getSwiftCode());
        if (request.getAccountNumber() != null) entity.setAccountNumber(request.getAccountNumber());
        if (request.getAccountType() != null) entity.setAccountType(request.getAccountType());
        if (request.getIfscCode() != null) entity.setIfscCode(request.getIfscCode());
        if (request.getBranchName() != null) entity.setBranchName(request.getBranchName());
        if (request.getNameOnAccount() != null) entity.setNameOnAccount(request.getNameOnAccount());
        if (request.getSalaryPaymentMode() != null) entity.setSalaryPaymentMode(request.getSalaryPaymentMode());
        if (request.getPfNumber() != null) entity.setPfNumber(request.getPfNumber());
        if (request.getPfJoiningDate() != null) entity.setPfJoiningDate(request.getPfJoiningDate());
        if (request.getEmployeeContributionToPf() != null)
            entity.setEmployeeContributionToPf(request.getEmployeeContributionToPf());
        if (request.getEsiDetailAvailable() != null) entity.setEsiDetailAvailable(request.getEsiDetailAvailable());
        if (request.getEsiEligible() != null) entity.setEsiEligible(request.getEsiEligible());
        if (request.getEmployeeEsiNumber() != null) entity.setEmployeeEsiNumber(request.getEmployeeEsiNumber());
        if (request.getLwfEligible() != null) entity.setLwfEligible(request.getLwfEligible());
        if (request.getAadharNumber() != null) entity.setAadharNumber(request.getAadharNumber());
        if (request.getDobInAadhar() != null) entity.setDobInAadhar(request.getDobInAadhar());
        if (request.getFullNameInAadhar() != null) entity.setFullNameInAadhar(request.getFullNameInAadhar());
        if (request.getGenderInAadhar() != null) entity.setGenderInAadhar(request.getGenderInAadhar());
        if (request.getPanAvailable() != null) entity.setPanAvailable(request.getPanAvailable());
        if (request.getPanNumber() != null) entity.setPanNumber(request.getPanNumber());
        if (request.getFullNameInPan() != null) entity.setFullNameInPan(request.getFullNameInPan());
        if (request.getDobInPan() != null) entity.setDobInPan(request.getDobInPan());
        if (request.getParentNameInPan() != null) entity.setParentNameInPan(request.getParentNameInPan());

        repository.save(entity);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("employee.financial.detail.updated"))
                .build();
    }
}
