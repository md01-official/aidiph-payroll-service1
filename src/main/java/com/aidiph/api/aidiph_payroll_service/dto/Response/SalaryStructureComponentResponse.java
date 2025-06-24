package com.aidiph.api.aidiph_payroll_service.dto.Response;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class SalaryStructureComponentResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String structureCode;
    private String componentCode;
    private String componentCategory;
    private Integer calculationPriority;
    private BigDecimal percentageOfBasic;
    private BigDecimal percentageOfCtc;
    private Long minValue;
    private Long maxValue;
    private Long defaultValue;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}