package com.aidiph.api.aidiph_payroll_service.service;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeePersonalDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeePersonalDetailResponse;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SuccessResponse;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeePersonDetailEntity;
import com.aidiph.api.aidiph_payroll_service.exception.ResourceNotFoundException;
import com.aidiph.api.aidiph_payroll_service.mapper.EmployeePersonalDetailMapper;
import com.aidiph.api.aidiph_payroll_service.repository.EmployeePersonalDetailRepo;
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
public class EmployeePersonalDetailServiceImpl implements EmployeePersonalDetailService{
    private final EmployeePersonalDetailRepo personalDetailRepo;
    private final EmployeePersonalDetailMapper employeePersonalDetailMapper;

    @Override
    public SuccessResponse addEmployeeDetail(EmployeePersonalDetailRequest employeePersonalDetail) {
        EmployeePersonDetailEntity employeePersonDetailEntity = employeePersonalDetailMapper.toEntity(employeePersonalDetail);
        personalDetailRepo.save(employeePersonDetailEntity);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("employee.is.created"))
                .build();
    }

    @Override
    public List<EmployeePersonalDetailResponse> getAllEmployeeDetails() {
        List<EmployeePersonDetailEntity> employeeEntities = personalDetailRepo.findAll();

        if (employeeEntities.isEmpty()) {
            throw new ResourceNotFoundException(MessageSourceUtils.getMessage("employee.not.found"));
        }

        return employeeEntities.stream()
                .map(employeePersonalDetailMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeePersonalDetailResponse getEmployeeDetailById(UUID id) {
        EmployeePersonDetailEntity entity = personalDetailRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        MessageSourceUtils.getMessage("employee.not.found", new Object[]{id})
                ));

        return employeePersonalDetailMapper.toEmployeePersonalDetailResponse(entity, new EmployeePersonalDetailResponse());
    }

    @Override
    public SuccessResponse updateEmployeeDetail(UUID id, EmployeePersonalDetailRequest request) {
        EmployeePersonDetailEntity entity = personalDetailRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("employee.not.found"));

        if (request.getMaritalStatus() != null) entity.setMaritalStatus(request.getMaritalStatus());
        if (request.getMarriageDate() != null) entity.setMarriageDate(request.getMarriageDate());
        if (request.getNationality() != null) entity.setNationality(request.getNationality());
        if (request.getPhysicallyChallenged() != null) entity.setPhysicallyChallenged(request.getPhysicallyChallenged());
        if (request.getDisabilityDetails() != null) entity.setDisabilityDetails(request.getDisabilityDetails());
        if (request.getFatherName() != null) entity.setFatherName(request.getFatherName());
        if (request.getMotherName() != null) entity.setMotherName(request.getMotherName());
        if (request.getSpouseName() != null) entity.setSpouseName(request.getSpouseName());
        if (request.getSpouseGender() != null) entity.setSpouseGender(request.getSpouseGender());
        if (request.getResidenceNumber() != null) entity.setResidenceNumber(request.getResidenceNumber());
        if (request.getSocialMediaHandles() != null) entity.setSocialMediaHandles(request.getSocialMediaHandles());
        if (request.getBloodGroup() != null) entity.setBloodGroup(request.getBloodGroup());

        personalDetailRepo.save(entity);

        return SuccessResponse.builder()
                .message(MessageSourceUtils.getMessage("employee.updated"))
                .build();
    }
}
