package com.aidiph.api.aidiph_payroll_service.dto.Request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationLocationRequest {

        @NotBlank(message = "Country code cannot be empty")
        @Size(max = 10, message = "Country code must be at most 10 characters")
        private String countryCode;

        @NotBlank(message = "Country name cannot be empty")
        @Size(max = 100, message = "Country name must be at most 100 characters")
        private String countryName;

        @NotBlank(message = "Dial code cannot be empty")
        @Size(max = 10, message = "Dial code must be at most 10 characters")
        private String dialCode;

        @NotBlank(message = "Currency code cannot be empty")
        @Size(max = 20, message = "Currency code must be at most 10 characters")
        private String currencyCode;

        @Size(max = 255, message = "Auth signatory designation must be at most 255 characters")
        private String authSignatoryDesignation;

        @Size(max = 50, message = "CIN must be at most 50 characters")
        private String cin;

        @Size(max = 10, message = "State code must be at most 10 characters")
        private String stateCode;

        @Size(max = 100, message = "State name must be at most 100 characters")
        private String stateName;

        @NotBlank(message = "Location name cannot be empty")
        @Size(max = 255, message = "Location name must be at most 255 characters")
        private String locationName;

        @NotBlank(message = "Location code cannot be empty")
        @Size(max = 50, message = "Location code must be at most 50 characters")
        private String locationCode;
        private Boolean isHeadOffice = false;
        private Boolean isRegisteredOffice = false;
        private Boolean isBranch = false;

        @Size(max = 255, message = "Address Line 1 must be at most 255 characters")
        private String addressLine1;

        @Size(max = 255, message = "Address Line 2 must be at most 255 characters")
        private String addressLine2;

        @Size(max = 100, message = "Locality must be at most 100 characters")
        private String locality;

        @NotBlank(message = "City cannot be empty")
        @Size(max = 100, message = "City must be at most 100 characters")
        private String city;

        @NotNull(message = "Pincode cannot be null")
        @Positive(message = "Pincode must be a positive number")
        private Long pincode;

        @Email(message = "Invalid email format")
        @Size(max = 255, message = "Email must be at most 255 characters")
        private String email;

        @NotNull(message = "Phone number cannot be null")
        private Long phone;

        @Size(max = 50, message = "GSTIN must be at most 50 characters")
        private String gstin;

        @Size(max = 50, message = "Timezone must be at most 50 characters")
        private String timezone;
}
