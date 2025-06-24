package com.aidiph.api.aidiph_payroll_service.mapper;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryStructureRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryStructureResponse;
import com.aidiph.api.aidiph_payroll_service.entity.SalaryStructureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface SalaryStructureMapper {
    SalaryStructureEntity toEntity(SalaryStructureRequest request);

    SalaryStructureResponse toResponse(SalaryStructureEntity entity);
}
