package com.aidiph.api.aidiph_payroll_service.dto.Response;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeFinancialDetailResponse {

    private UUID id;
    private UUID employeeNumber;
    private String employeeFirstName;
    private String complianceCode;
    private String orgPfNumber;
    private String bankType;
    private String bankCode;
    private String swiftCode;
    private Long accountNumber;
    private String accountType;
    private String ifscCode;
    private String branchName;
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
    private Long aadharNumber;
    private LocalDate dobInAadhar;
    private String fullNameInAadhar;
    private String genderInAadhar;
    private Boolean panAvailable;
    private String panNumber;
    private String fullNameInPan;
    private LocalDate dobInPan;
    private String parentNameInPan;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}