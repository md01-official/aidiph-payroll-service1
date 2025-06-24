package com.aidiph.api.aidiph_payroll_service.mapper;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryStructureComponentRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.SalaryStructureComponentResponse;
import com.aidiph.api.aidiph_payroll_service.entity.SalaryStructureComponentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface SalaryStructureComponentMapper {
    SalaryStructureComponentEntity toEntity(SalaryStructureComponentRequest request);

    SalaryStructureComponentResponse toResponse(SalaryStructureComponentEntity entity);
}
