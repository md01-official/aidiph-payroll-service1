package com.aidiph.api.aidiph_payroll_service.dto.Response;

import com.aidiph.api.aidiph_payroll_service.entity.EmployeePersonDetailEntity;
import com.aidiph.api.aidiph_payroll_service.enums.MaritalStatus;
import com.aidiph.api.aidiph_payroll_service.enums.SpouseGender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePersonalDetailResponse {
    private UUID id;
    private MaritalStatus maritalStatus;
    private LocalDate marriageDate;
    private String bloodGroup;
    private String  nationality;
    private boolean physicallyChallenged;
    private boolean disabilityDetails;
    private String  fatherName;
    private String motherName;
    private String spouseName;
    private SpouseGender spouseGender;
    private Long residenceNumber;
    private String socialMediaHandles;

    private LocalDateTime createdAt;
    private UUID createdBy;
    private UUID updatedBy;
    private LocalDateTime updatedAt;

}
