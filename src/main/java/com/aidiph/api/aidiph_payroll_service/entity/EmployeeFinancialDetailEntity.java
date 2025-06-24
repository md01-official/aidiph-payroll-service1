package com.aidiph.api.aidiph_payroll_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbl_employee_financial_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class EmployeeFinancialDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    private Boolean pfDetailAvailable = false;
    private String pfNumber;
    private LocalDate pfJoiningDate;
    private String employeeContributionToPf;

    private Boolean esiDetailAvailable = false;
    private Boolean esiEligible = false;
    private Long employeeEsiNumber;

    private Boolean lwfEligible = false;
    private Long aadharNumber;

    private LocalDate dobInAadhar;
    private String fullNameInAadhar;
    private String genderInAadhar;

    private Boolean panAvailable = false;
    private String panNumber;

    private String fullNameInPan;
    private LocalDate dobInPan;
    private String parentNameInPan;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
}
