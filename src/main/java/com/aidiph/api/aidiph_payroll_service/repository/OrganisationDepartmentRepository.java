package com.aidiph.api.aidiph_payroll_service.repository;

import com.aidiph.api.aidiph_payroll_service.entity.OrganisationDepartmentEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganisationDepartmentRepository extends JpaRepository<OrganisationDepartmentEntity, UUID> {
    boolean existsByDeptCode(@NotBlank(message = "Department code is required") @Size(max = 50, message = "Department code must not exceed 50 characters") String deptCode);
}
