package com.aidiph.api.aidiph_payroll_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbl_organisation_locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class OrganisationLocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String countryCode;
    private String countryName;
    private String dialCode;
    private String currencyCode;
    private String authSignatoryDesignation;
    private String cin;
    private String stateCode;
    private String stateName;
    private String locationName;
    private String locationCode;
    private Boolean isHeadOffice;
    private Boolean isRegisteredOffice;
    private Boolean isBranch;
    private String addressLine1;
    private String addressLine2;
    private String locality;
    private String city;
    private Long pincode;
    private String email;
    private Long phone;
    private String gstin;
    private String timezone;
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private UUID createdBy;
    @LastModifiedBy
    private UUID updatedBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
