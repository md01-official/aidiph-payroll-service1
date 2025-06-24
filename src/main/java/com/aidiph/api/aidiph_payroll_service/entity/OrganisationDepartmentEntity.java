package com.aidiph.api.aidiph_payroll_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbl_organisation_departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class OrganisationDepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @CreatedDate
    private LocalDateTime createdAt;
    private UUID createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private UUID updatedBy;
}
