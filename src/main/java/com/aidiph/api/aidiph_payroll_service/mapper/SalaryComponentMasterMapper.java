package com.aidiph.api.aidiph_payroll_service.mapper;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryComponentMasterRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryComponentMasterResponse;
import com.aidiph.api.aidiph_payroll_service.entity.SalaryComponentMasterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface SalaryComponentMasterMapper {
    SalaryComponentMasterResponse toResponse(SalaryComponentMasterEntity salaryComponentMasterEntity);

    SalaryComponentMasterEntity toEntity(SalaryComponentMasterRequest request);
}
