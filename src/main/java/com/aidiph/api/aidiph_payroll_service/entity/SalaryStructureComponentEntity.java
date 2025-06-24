package com.aidiph.api.aidiph_payroll_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbl_salary_structure_component")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class SalaryStructureComponentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String structureName;
    private String structureCode;
    private String componentCode;
    private String componentCategory;
    private Integer calculationPriority;
    private BigDecimal percentageOfBasic;
    private BigDecimal percentageOfCtc;
    private Long minValue;
    private Long maxValue;
    private Long defaultValue;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}
