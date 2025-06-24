package com.aidiph.api.aidiph_payroll_service.entity;

import com.aidiph.api.aidiph_payroll_service.enums.MaritalStatus;
import com.aidiph.api.aidiph_payroll_service.enums.SpouseGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_employee_personal_detail")
@EntityListeners(AuditingEntityListener.class)
public class EmployeePersonDetailEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    private LocalDate marriageDate;
    private String bloodGroup;
    private String  nationality;
    private Boolean physicallyChallenged;
    private Boolean disabilityDetails;
    private String  fatherName;
    private String motherName;
    private String spouseName;
    @Enumerated(EnumType.STRING)
    private SpouseGender spouseGender;
    private Long residenceNumber;
    private String socialMediaHandles;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private UUID createdBy;
    @LastModifiedBy
    private UUID updatedBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
