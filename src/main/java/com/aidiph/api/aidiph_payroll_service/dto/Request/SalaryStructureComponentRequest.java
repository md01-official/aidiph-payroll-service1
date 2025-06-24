package com.aidiph.api.aidiph_payroll_service.dto.Request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryStructureComponentRequest {

    @NotBlank(message = "Structure name is required.")
    @Size(max = 100, message = "Structure name must not exceed 100 characters.")
    private String structureName;
    @NotBlank(message = "Structure code is required.")
    @Size(max = 100, message = "Structure code must not exceed 100 characters.")
    private String structureCode;

    @NotBlank(message = "Component code is required.")
    @Size(max = 100, message = "Component code must not exceed 100 characters.")
    private String componentCode;

    @NotBlank(message = "Component category is required.")
    @Size(max = 100, message = "Component category must not exceed 100 characters.")
    private String componentCategory;

    @NotNull(message = "Calculation priority is required.")
    @Min(value = 1, message = "Calculation priority must be at least 1.")
    private Integer calculationPriority;

    @DecimalMin(value = "0.00", message = "Percentage of basic must be a positive value.")
    @DecimalMax(value = "100.00", message = "Percentage of basic cannot exceed 100%.")
    private BigDecimal percentageOfBasic;

    @DecimalMin(value = "0.00", message = "Percentage of CTC must be a positive value.")
    @DecimalMax(value = "100.00", message = "Percentage of CTC cannot exceed 100%.")
    private BigDecimal percentageOfCtc;

    @PositiveOrZero(message = "Min value must be zero or positive.")
    private Long minValue;

    @PositiveOrZero(message = "Max value must be zero or positive.")
    private Long maxValue;

    @PositiveOrZero(message = "Default value must be zero or positive.")
    private Long defaultValue;
}

