package com.aidiph.api.aidiph_payroll_service.repository;

import com.aidiph.api.aidiph_payroll_service.entity.SalaryComponentMasterEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalaryComponentMasterRepository extends JpaRepository<SalaryComponentMasterEntity, UUID> {
    boolean existsByComponentCode( String componentCode);
}
