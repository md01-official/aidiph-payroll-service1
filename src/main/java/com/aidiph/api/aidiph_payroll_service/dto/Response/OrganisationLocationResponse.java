package com.aidiph.api.aidiph_payroll_service.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationLocationResponse {
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
    private LocalDateTime updatedAt;
}
