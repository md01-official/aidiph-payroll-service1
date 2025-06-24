package com.aidiph.api.aidiph_payroll_service.dto.Request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryComponentMasterRequest {

    @NotBlank(message = "Component name is required.")
    @Size(max = 255, message = "Component name must not exceed 255 characters.")
    private String componentName;

    private String authSignatoryDesignation;

    @NotBlank(message = "CIN is required.")
    @Pattern(regexp = "^[A-Z0-9]{21}$", message = "Invalid CIN format. It must be 21 uppercase alphanumeric characters.")
    private String cin;

    @NotBlank(message = "Component code is required.")
    @Size(max = 100, message = "Component code must not exceed 100 characters.")
    private String componentCode;

    private String componentCategory;
    private String componentType;
    private String calculationType;
    private String calculationBasis;
    private String calculationFormula;
    private String calculationFrequency;

    private Boolean isTaxable;
    private Boolean considerForCtc;
    private Boolean considerForEsi;
    private Boolean considerForPf;
    private Boolean considerForBonus;

    private String minValue;
    private String maxValue;

    @Min(value = 0, message = "Rounding factor must be a positive integer.")
    private int roundingFactor;

    private String printName;
    private String description;
}