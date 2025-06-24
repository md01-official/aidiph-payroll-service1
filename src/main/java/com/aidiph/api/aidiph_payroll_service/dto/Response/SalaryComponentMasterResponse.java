package com.aidiph.api.aidiph_payroll_service.dto.Response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryComponentMasterResponse {

    private UUID id;
    private String componentName;
    private String authSignatoryDesignation;
    private String cin;
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
    private int roundingFactor;
    private String printName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

