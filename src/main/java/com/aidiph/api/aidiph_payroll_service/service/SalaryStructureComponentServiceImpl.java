package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryStructureComponentRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryStructureComponentResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.SalaryStructureComponentEntity;
import com.aidiph.api.aidiph_payroll_service.exception.InvalidInputException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceAlreadyExistsException;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceNotFoundException;
import com.aidiph.api.aidiph_payroll_service.mapper.SalaryStructureComponentMapper;
import com.aidiph.api.aidiph_payroll_service.repository.SalaryComponentMasterRepository;
import com.aidiph.api.aidiph_payroll_service.repository.SalaryStructureComponentRepository;
import com.aidiph.api.aidiph_payroll_service.repository.SalaryStructureRepository;
import com.aidiph.api.aidiph_payroll_service.utils.MessageSourceUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalaryStructureComponentServiceImpl implements SalaryStructureComponentService {

    private final SalaryStructureComponentRepository repository;
    private final SalaryStructureComponentMapper mapper;
    private final SalaryStructureRepository salaryStructureRepository;
    private final SalaryComponentMasterRepository salaryComponentMasterRepository;

    @Override
    public SuccessResponse createSalaryComponent(SalaryStructureComponentRequest request) {
        log.info("Creating salary component: {}", request.getComponentCode());

        boolean structureExists = salaryStructureRepository.existsByStructureCode(request.getStructureCode());
        if (!structureExists) {
            throw new ResourceNotFoundException("Salary structure not found: " + request.getStructureCode());
        }

        boolean componentExists = salaryComponentMasterRepository.existsByComponentCode(request.getComponentCode());
        if (!componentExists) {
            throw new ResourceNotFoundException("Salary component not found: " + request.getComponentCode());
        }

        boolean exists = repository.existsByStructureCodeAndComponentCode(request.getStructureCode(), request.getComponentCode());
        if (exists) {
            throw new ResourceAlreadyExistsException("Component already exists in the salary structure: " + request.getStructureCode());
        }

        if (request.getPercentageOfBasic() != null && request.getPercentageOfBasic().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new InvalidInputException("Percentage of Basic cannot exceed 100%");
        }
        if (request.getPercentageOfCtc() != null && request.getPercentageOfCtc().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new InvalidInputException("Percentage of CTC cannot exceed 100%");
        }

        if (request.getCalculationPriority() <= 0) {
            throw new InvalidInputException("Calculation priority must be greater than 0");
        }

        if (request.getMinValue() != null && request.getMinValue() < 0) {
            throw new InvalidInputException("Min value must be non-negative");
        }
        if (request.getMaxValue() != null && request.getMaxValue() < 0) {
            throw new InvalidInputException("Max value must be non-negative");
        }
        if (request.getDefaultValue() != null && request.getDefaultValue() < 0) {
            throw new InvalidInputException("Default value must be non-negative");
        }

        SalaryStructureComponentEntity entity = mapper.toEntity(request);
        repository.save(entity);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("salary.component.created"))
                .build();
    }

    @Override
    public SalaryStructureComponentResponse getSalaryComponentById(UUID id) {
        log.info("Fetching salary component details for ID: {}", id);
        SalaryStructureComponentEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salary component not found with ID: " + id));

        return mapper.toResponse(entity);
    }

    @Override
    public List<SalaryStructureComponentResponse> getAllSalaryComponents() {
        log.info("Fetching all salary components");
        List<SalaryStructureComponentEntity> entities = repository.findAll();

        if (entities.isEmpty()) {
            throw new ResourceNotFoundException(MessageSourceUtils.getMessage("salary.component.not.found"));
        }

        return entities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<SalaryStructureComponentResponse> getComponentsByStructureCode(String structureCode) {
        log.info("Fetching salary components for structure: {}", structureCode);
        List<SalaryStructureComponentEntity> components = repository.findByStructureCode(structureCode);

        if (components.isEmpty()) {
            throw new ResourceNotFoundException("No components found for salary structure: " + structureCode);
        }

        return components.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessResponse updateSalaryComponent(UUID id, SalaryStructureComponentRequest request) {
        log.info("Updating salary component ID: {}", id);

        SalaryStructureComponentEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary component not found with ID: " + id));

        boolean structureExists = salaryStructureRepository.existsByStructureCode(request.getStructureCode());
        if (!structureExists) {
            throw new ResourceNotFoundException("Salary structure not found: " + request.getStructureCode());
        }

        boolean componentExists = salaryComponentMasterRepository.existsByComponentCode(request.getComponentCode());
        if (!componentExists) {
            throw new ResourceNotFoundException("Salary component not found: " + request.getComponentCode());
        }
        boolean exists = repository.existsByStructureCodeAndComponentCode(request.getStructureCode(), request.getComponentCode());
        if (exists) {
            throw new ResourceAlreadyExistsException("Component already exists in the salary structure: " + request.getStructureCode());
        }

        if (request.getPercentageOfBasic() != null && request.getPercentageOfBasic().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new InvalidInputException("Percentage of Basic cannot exceed 100%");
        }
        if (request.getPercentageOfCtc() != null && request.getPercentageOfCtc().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new InvalidInputException("Percentage of CTC cannot exceed 100%");
        }

        if (request.getCalculationPriority() <= 0) {
            throw new InvalidInputException("Calculation priority must be greater than 0");
        }

        if (request.getMinValue() != null && request.getMinValue() < 0) {
            throw new InvalidInputException("Min value must be non-negative");
        }
        if (request.getMaxValue() != null && request.getMaxValue() < 0) {
            throw new InvalidInputException("Max value must be non-negative");
        }
        if (request.getDefaultValue() != null && request.getDefaultValue() < 0) {
            throw new InvalidInputException("Default value must be non-negative");
        }

        if (request.getCalculationPriority() != null) entity.setCalculationPriority(request.getCalculationPriority());
        if (request.getPercentageOfBasic() != null) entity.setPercentageOfBasic(request.getPercentageOfBasic());
        if (request.getPercentageOfCtc() != null) entity.setPercentageOfCtc(request.getPercentageOfCtc());
        if (request.getMinValue() != null) entity.setMinValue(request.getMinValue());
        if (request.getMaxValue() != null) entity.setMaxValue(request.getMaxValue());
        if (request.getDefaultValue() != null) entity.setDefaultValue(request.getDefaultValue());

        repository.save(entity);

        return SuccessResponse.builder().message(MessageSourceUtils.getMessage("salary.component.updated")).build();
    }

}