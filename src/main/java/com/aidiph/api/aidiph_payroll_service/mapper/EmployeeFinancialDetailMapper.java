package com.aidiph.api.aidiph_payroll_service.mapper;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeeFinancialDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeeFinancialDetailResponse;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeeFinancialDetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface EmployeeFinancialDetailMapper {
    EmployeeFinancialDetailResponse toResponse(EmployeeFinancialDetailEntity entity);

    EmployeeFinancialDetailEntity toEntity(EmployeeFinancialDetailRequest request);
}
