package com.aidiph.api.aidiph_payroll_service.dto.Response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDataResponse {
    private UUID id;
    private String typeName;
    private String typeCode;
    private String description;
    private String authSignatoryDesignation;
    private String cin;
    private String titleName;
    private String titleCode;
    private String titleDescription;
    private Integer gradeLevel;
    private UUID employeeId;
    private String deptTypeCode;
    private String deptCode;
    private String workLocationCode;
    private String workLocationCity;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String displayName;
    private LocalDate dateOfBirth;
    private String gender;
    private String officialEmail;
    private String personalEmail;
    private Long mobileNumber;
    private String emergencyContactName;
    private String emergencyContactRelationship;
    private Long emergencyContactNumber;
    private LocalDate dateJoined;
    private LocalDate probationEndDate;
    private LocalDate confirmationDate;
    private LocalDate contractEndDate;
    private UUID reportingManagerEmployeeNumber;
    private String reportingManagerFirstName;
    private Long noticePeriodDays;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime updatedAt;
    private UUID updatedBy;
}

