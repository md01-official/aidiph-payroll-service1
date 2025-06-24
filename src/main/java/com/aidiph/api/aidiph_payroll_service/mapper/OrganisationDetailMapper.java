package com.aidiph.api.aidiph_payroll_service.mapper;

import com.aidiph.api.aidiph_payroll_service.dto.Request.OrganisationDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.OrganisationDetailResponse;
import com.aidiph.api.aidiph_payroll_service.entity.OrganisationDetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface OrganisationDetailMapper {
    OrganisationDetailEntity toEntity(OrganisationDetailRequest request);

    OrganisationDetailResponse toOrganisationDetailResponse(OrganisationDetailEntity entity, @MappingTarget OrganisationDetailResponse organisationDetailResponse);

    OrganisationDetailResponse toResponse(OrganisationDetailEntity organisationDetailEntity);

}
