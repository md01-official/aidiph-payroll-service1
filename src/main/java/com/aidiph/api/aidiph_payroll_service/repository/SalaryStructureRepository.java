package com.aidiph.api.aidiph_payroll_service.repository;

import com.aidiph.api.aidiph_payroll_service.entity.SalaryStructureEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalaryStructureRepository extends JpaRepository<SalaryStructureEntity, UUID> {
    boolean existsByStructureCode(String structureCode);
}
