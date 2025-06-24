package com.aidiph.api.aidiph_payroll_service.mapper;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeePersonalDetailRequest;
import com.aidiph.api.aidiph_payroll_service.dto.Response.EmployeePersonalDetailResponse;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeePersonDetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface EmployeePersonalDetailMapper {
   EmployeePersonalDetailResponse toEmployeePersonalDetailResponse(EmployeePersonDetailEntity entity, @MappingTarget EmployeePersonalDetailResponse employeePersonalDetailResponse);

    EmployeePersonDetailEntity toEntity(EmployeePersonalDetailRequest employeePersonalDetail);

    EmployeePersonalDetailResponse toResponse(EmployeePersonDetailEntity employeePersonDetailEntity);
}
