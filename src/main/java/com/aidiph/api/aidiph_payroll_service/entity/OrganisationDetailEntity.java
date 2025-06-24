package com.aidiph.api.aidiph_payroll_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbl_organisation_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrganisationDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String legalEntityName;
    private String authSignatoryName;
    private String authSignatoryDesignation;
    private String authSignatoryEmail;
    private String authSignatoryFatherName;
    private LocalDate corporationDate;
    private String cin;
    private String bankType;
    private String bankName;
    private Long bankCode;
    private String swiftCode;
    private String accountNumber;
    private String ifscCode;
    private String branchName;
    private String nameOnAccount;
    private String pan;
    private String tan;
    private String tanCircleNumber;
    private String corporateIncomeTaxLocations;
    private String complianceCode;
    private String pfEstablishmentId;
    private String pfNumber;
    private LocalDate pfRegistrationDate;
    private String esiNumber;
    private LocalDate esiRegistrationDate;
    private String ptEstablishmentId;
    private String ptNumber;
    private LocalDate ptRegistrationDate;
    private String lwfEstablishmentId;
    private LocalDate lwfRegistrationDate;
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private UUID createdBy;
    @LastModifiedBy
    private UUID updatedBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
