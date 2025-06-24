package com.aidiph.api.aidiph_payroll_service.mapper;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationLocationRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationLocationResponse;
import com.aidiph.api.aidiph_payroll_service.entity.OrganisationLocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface OrganisationLocationMapper {
    OrganisationLocationEntity toEntity(OrganisationLocationRequest request);

    OrganisationLocationEntity toResponse(OrganisationLocationEntity organisationLocationEntity);

    OrganisationLocationResponse toOrganisationLocationResponse(OrganisationLocationEntity entity);
}
