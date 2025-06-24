package com.aidiph.api.aidiph_payroll_service.dto.Request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganisationDepartmentRequest {

    @NotBlank(message = "Type name is required")
    @Size(max = 255, message = "Type name must not exceed 255 characters")
    private String typeName;

    @NotBlank(message = "Type code is required")
    @Size(max = 50, message = "Type code must not exceed 50 characters")
    private String typeCode;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @Size(max = 255, message = "Auth Signatory Designation must not exceed 255 characters")
    private String authSignatoryDesignation;

    @NotBlank(message = "CIN is required")
    @Pattern(regexp = "^[A-Z0-9]{21}$", message = "Invalid CIN format")
    private String cin;

    @NotBlank(message = "Department code is required")
    @Size(max = 50, message = "Department code must not exceed 50 characters")
    private String deptCode;

    @NotBlank(message = "Department name is required")
    @Size(max = 255, message = "Department name must not exceed 255 characters")
    private String deptName;

    @Size(max = 50, message = "Parent Department Type Code must not exceed 50 characters")
    private String parentDeptTypeCode;

    @Size(max = 50, message = "Parent Department Code must not exceed 50 characters")
    private String parentDeptCode;

    @Size(max = 50, message = "Cost Center Code must not exceed 50 characters")
    private String costCenterCode;

    @Size(max = 500, message = "Department Description must not exceed 500 characters")
    private String deptDescription;
}
