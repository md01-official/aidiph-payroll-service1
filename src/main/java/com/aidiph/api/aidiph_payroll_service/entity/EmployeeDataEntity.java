package com.aidiph.api.aidiph_payroll_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbl_employee_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class EmployeeDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @CreatedDate
    private LocalDateTime createdAt;
    private UUID createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private UUID updatedBy;
}