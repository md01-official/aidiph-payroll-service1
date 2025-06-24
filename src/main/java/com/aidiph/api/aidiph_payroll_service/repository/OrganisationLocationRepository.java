package com.aidiph.api.aidiph_payroll_service.repository;

import com.aidiph.api.aidiph_payroll_service.entity.OrganisationLocationEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganisationLocationRepository extends JpaRepository<OrganisationLocationEntity, UUID> {
    boolean existsByLocationCode(String locationCode);

    boolean existsByEmail(String email);
}
