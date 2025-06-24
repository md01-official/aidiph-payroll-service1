package com.aidiph.api.aidiph_payroll_service.mapper;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeeDataRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeeDataResponse;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeeDataEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface EmployeeDataMapper {
    EmployeeDataEntity toEntity(EmployeeDataRequest request);

    EmployeeDataResponse toEmployeeDataResponse(EmployeeDataEntity entity);

    EmployeeDataResponse toResponse(EmployeeDataEntity employeeDataEntity);
}
