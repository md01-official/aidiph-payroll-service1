package com.aidiph.api.aidiph_payroll_service.dto.Response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganisationDepartmentResponse {
    private UUID id;
    private String typeName;
    private String typeCode;
    private String description;
    private String authSignatoryDesignation;
    private String cin;
    private String deptCode;
    private String deptName;
    private String parentDeptTypeCode;
    private String parentDeptCode;
    private String costCenterCode;
    private String deptDescription;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime updatedAt;
    private UUID updatedBy;
}
