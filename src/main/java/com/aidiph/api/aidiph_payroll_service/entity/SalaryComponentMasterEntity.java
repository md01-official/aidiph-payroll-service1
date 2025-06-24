package com.aidiph.api.aidiph_payroll_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbl_salary_component_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SalaryComponentMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}

