package com.aidiph.api.aidiph_payroll_service.dto.Request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeFinancialDetailRequest {

    @NotNull(message = "Employee number is required.")
    private UUID employeeNumber;

    @NotBlank(message = "Employee first name is required.")
    @Size(max = 255, message = "Employee first name must not exceed 255 characters.")
    private String employeeFirstName;

    private String complianceCode;
    private String orgPfNumber;

    @NotBlank(message = "Bank type is required.")
    private String bankType;

    private String bankCode;
    private String swiftCode;

    @NotNull(message = "Account number is required.")
    @Positive(message = "Account number must be a positive value.")
    private Long accountNumber;

    @NotBlank(message = "Account type is required.")
    private String accountType;

    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Invalid IFSC code format.")
    private String ifscCode;

    private String branchName;

    @NotBlank(message = "Name on account is required.")
    private String nameOnAccount;

    private String salaryPaymentMode;

    private Boolean pfDetailAvailable;
    private String pfNumber;
    private LocalDate pfJoiningDate;
    private String employeeContributionToPf;

    private Boolean esiDetailAvailable;
    private Boolean esiEligible;

    private Long employeeEsiNumber;
    private Boolean lwfEligible;

    @Positive(message = "Aadhar number must be a positive number.")
    @Digits(integer = 12, fraction = 0, message = "Aadhar number must be a 12-digit number.")
    private Long aadharNumber;

    private LocalDate dobInAadhar;
    private String fullNameInAadhar;
    private String genderInAadhar;

    private Boolean panAvailable;

    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN number format.")
    private String panNumber;

    private String fullNameInPan;
    private LocalDate dobInPan;
    private String parentNameInPan;
}