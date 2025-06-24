package com.aidiph.api.aidiph_payroll_service.dto.Response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryStructureResponse {

    private UUID id;
    private String structureName;
    private String authSignatoryDesignation;
    private String cin;
    private String structureCode;
    private String description;
    private Long minCtc;
    private Long maxCtc;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private Boolean isDefault;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}