package com.aidiph.api.aidiph_payroll_service.dto.Request;

import com.aidiph.api.aidiph_payroll_service.enums.MaritalStatus;
import com.aidiph.api.aidiph_payroll_service.enums.SpouseGender;

import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeePersonalDetailRequest {
    @NotNull(message = "Marital status is required.")
    private MaritalStatus maritalStatus;

    @PastOrPresent(message = "Marriage date cannot be in the future.")
    private LocalDate marriageDate;

    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group. Allowed: A+, A-, B+, B-, AB+, AB-, O+, O-")
    private String bloodGroup;

    @NotBlank(message = "Nationality is required.")
    @Size(max = 50, message = "Nationality should not exceed 50 characters.")
    private String nationality;

    @NotNull(message = "Physically challenged status is required.")
    private Boolean physicallyChallenged;

    @NotNull(message = "Disability details are required.")
    private Boolean disabilityDetails;

    @NotBlank(message = "Father's name is required.")
    @Size(max = 100, message = "Father's name should not exceed 100 characters.")
    private String fatherName;

    @NotBlank(message = "Mother's name is required.")
    @Size(max = 100, message = "Mother's name should not exceed 100 characters.")
    private String motherName;

    private String spouseName;
    private SpouseGender spouseGender;

    @Min(value = 1, message = "Residence number must be a positive number.")
    private Long residenceNumber;

    @Size(max = 255, message = "Social media handles should not exceed 255 characters.")
    private String socialMediaHandles;
    }

