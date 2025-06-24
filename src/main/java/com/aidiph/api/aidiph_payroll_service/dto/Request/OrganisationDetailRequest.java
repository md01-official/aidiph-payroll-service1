package com.aidiph.api.aidiph_payroll_service.dto.Request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationDetailRequest {

    @NotBlank(message = "Legal entity name cannot be empty")
    @Size(max = 255, message = "Legal entity name must be at most 255 characters")
    private String legalEntityName;

    @NotBlank(message = "Auth signatory name cannot be empty")
    @Size(max = 255, message = "Auth signatory name must be at most 255 characters")
    private String authSignatoryName;

    @NotBlank(message = "Auth signatory designation cannot be empty")
    @Size(max = 255, message = "Auth signatory designation must be at most 255 characters")
    private String authSignatoryDesignation;

    @NotBlank(message = "Auth signatory email cannot be empty")
    @Email(message = "Invalid email format")
    @Size(max = 255, message = "Email must be at most 255 characters")
    private String authSignatoryEmail;

    @NotBlank(message = "Auth signatory father's name cannot be empty")
    @Size(max = 255, message = "Auth signatory father's name must be at most 255 characters")
    private String authSignatoryFatherName;

    @PastOrPresent(message = "Corporation date must be in the past or today")
    private LocalDate corporationDate;

    @NotBlank(message = "CIN cannot be empty")
    @Size(max = 50, message = "CIN must be at most 50 characters")
    private String cin;

    @Size(max = 50, message = "Bank type must be at most 50 characters")
    private String bankType;

    @Size(max = 255, message = "Bank name must be at most 255 characters")
    private String bankName;

    @Positive(message = "Bank code must be a positive number")
    private Long bankCode;

    @Size(max = 50, message = "Swift code must be at most 50 characters")
    private String swiftCode;

    @NotBlank(message = "Account number cannot be empty")
    @Size(max = 50, message = "Account number must be at most 50 characters")
    private String accountNumber;

    @NotBlank(message = "IFSC code cannot be empty")
    @Size(max = 50, message = "IFSC code must be at most 50 characters")
    private String ifscCode;

    @Size(max = 255, message = "Branch name must be at most 255 characters")
    private String branchName;

    @Size(max = 255, message = "Name on account must be at most 255 characters")
    private String nameOnAccount;

    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN format")
    private String pan;

    @Size(max = 20, message = "TAN must be at most 20 characters")
    private String tan;

    @Size(max = 50, message = "TAN Circle Number must be at most 50 characters")
    private String tanCircleNumber;

    @Size(max = 500, message = "Corporate income tax locations must be at most 500 characters")
    private String corporateIncomeTaxLocations;

    @Size(max = 100, message = "Compliance code must be at most 100 characters")
    private String complianceCode;

    @Size(max = 50, message = "PF establishment ID must be at most 50 characters")
    private String pfEstablishmentId;

    @Size(max = 50, message = "PF number must be at most 50 characters")
    private String pfNumber;

    @PastOrPresent(message = "PF registration date must be in the past or today")
    private LocalDate pfRegistrationDate;

    @Size(max = 50, message = "ESI number must be at most 50 characters")
    private String esiNumber;

    @PastOrPresent(message = "ESI registration date must be in the past or today")
    private LocalDate esiRegistrationDate;

    @Size(max = 50, message = "PT establishment ID must be at most 50 characters")
    private String ptEstablishmentId;

    @Size(max = 50, message = "PT number must be at most 50 characters")
    private String ptNumber;

    @PastOrPresent(message = "PT registration date must be in the past or today")
    private LocalDate ptRegistrationDate;

    @Size(max = 50, message = "LWF establishment ID must be at most 50 characters")
    private String lwfEstablishmentId;

    @PastOrPresent(message = "LWF registration date must be in the past or today")
    private LocalDate lwfRegistrationDate;
}