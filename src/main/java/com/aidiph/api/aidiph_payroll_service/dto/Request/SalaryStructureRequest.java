package com.aidiph.api.aidiph_payroll_service.dto.Request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryStructureRequest {

    @NotBlank(message = "Structure name is required.")
    @Size(max = 255, message = "Structure name must not exceed 255 characters.")
    private String structureName;

    private String authSignatoryDesignation;

    @NotBlank(message = "CIN is required.")
    @Pattern(regexp = "^[A-Z0-9]{21}$", message = "Invalid CIN format. It must be 21 uppercase alphanumeric characters.")
    private String cin;

    @NotBlank(message = "Structure code is required.")
    @Size(max = 100, message = "Structure code must not exceed 100 characters.")
    private String structureCode;

    private String description;

    @NotNull(message = "Minimum CTC is required.")
    @Positive(message = "Minimum CTC must be greater than zero.")
    private Long minCtc;

    @NotNull(message = "Maximum CTC is required.")
    @Positive(message = "Maximum CTC must be greater than zero.")
    private Long maxCtc;

    @NotNull(message = "Effective from date is required.")
    private LocalDate effectiveFrom;

    private LocalDate effectiveTo;

    private Boolean isDefault;
}