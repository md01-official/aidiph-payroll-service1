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
public class EmployeeDataRequest {
    @NotBlank(message = "Type name is required.")
    private String typeName;

    @NotBlank(message = "Type code is required.")
    private String typeCode;

    @Size(max = 500, message = "Description must not exceed 500 characters.")
    private String description;

    @Size(max = 255, message = "Auth Signatory Designation must not exceed 255 characters.")
    private String authSignatoryDesignation;

    @NotBlank(message = "CIN is required.")
    @Pattern(regexp = "^[A-Z0-9]{21}$", message = "Invalid CIN format. Must be 21 uppercase alphanumeric characters.")
    private String cin;

    private String titleName;
    private String titleCode;

    @Size(max = 500, message = "Title description must not exceed 500 characters.")
    private String titleDescription;

    @Min(value = 1, message = "Grade level must be at least 1.")
    private Integer gradeLevel;

    @NotNull(message = "Employee ID is required.")
    private UUID employeeId;

    private String deptTypeCode;
    private String deptCode;
    private String workLocationCode;
    private String workLocationCity;

    private String title;

    @NotBlank(message = "First name is required.")
    @Size(max = 100, message = "First name must not exceed 100 characters.")
    private String firstName;

    @Size(max = 100, message = "Middle name must not exceed 100 characters.")
    private String middleName;

    @NotBlank(message = "Last name is required.")
    @Size(max = 100, message = "Last name must not exceed 100 characters.")
    private String lastName;

    @Size(max = 255, message = "Display name must not exceed 255 characters.")
    private String displayName;

    @NotNull(message = "Date of birth is required.")
    @Past(message = "Date of birth must be in the past.")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is required.")
    private String gender;

    @NotBlank(message = "Official email is required.")
    @Email(message = "Invalid official email format.")
    private String officialEmail;

    @Email(message = "Invalid personal email format.")
    private String personalEmail;

    @NotNull(message = "Mobile number is required.")
    @Digits(integer = 10, fraction = 0, message = "Mobile number must be a valid 10-digit number.")
    private Long mobileNumber;

    @Size(max = 255, message = "Emergency contact name must not exceed 255 characters.")
    private String emergencyContactName;

    @Size(max = 100, message = "Emergency contact relationship must not exceed 100 characters.")
    private String emergencyContactRelationship;

    @Digits(integer = 10, fraction = 0, message = "Emergency contact number must be a valid 10-digit number.")
    private Long emergencyContactNumber;

    @NotNull(message = "Date joined is required.")
    @PastOrPresent(message = "Date joined cannot be in the future.")
    private LocalDate dateJoined;

    @PastOrPresent(message = "Probation end date cannot be in the future.")
    private LocalDate probationEndDate;

    @PastOrPresent(message = "Confirmation date cannot be in the future.")
    private LocalDate confirmationDate;

    @FutureOrPresent(message = "Contract end date cannot be in the past.")
    private LocalDate contractEndDate;

    private UUID reportingManagerEmployeeNumber;

    @Size(max = 100, message = "Reporting manager's first name must not exceed 100 characters.")
    private String reportingManagerFirstName;

    @Min(value = 0, message = "Notice period days cannot be negative.")
    private Long noticePeriodDays;
}
