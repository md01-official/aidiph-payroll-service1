package com.aidiph.api.aidiph_payroll_service.repository;

import com.aidiph.api.aidiph_payroll_service.entity.OrganisationDetailEntity;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrganisationDetailRepository extends JpaRepository<OrganisationDetailEntity, UUID> {
    boolean existsByCin(String cin);

}
