package com.aidiph.api.aidiph_payroll_service.mapper;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDepartmentRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationDepartmentResponse;
import com.aidiph.api.aidiph_payroll_service.entity.OrganisationDepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface OrganisationDepartmentMapper {
    OrganisationDepartmentEntity toEntity(OrganisationDepartmentRequest request);

    OrganisationDepartmentResponse toOrganisationDepartmentResponse(OrganisationDepartmentEntity entity);

    OrganisationDepartmentResponse toResponse(OrganisationDepartmentEntity organisationDepartmentEntity);
}
