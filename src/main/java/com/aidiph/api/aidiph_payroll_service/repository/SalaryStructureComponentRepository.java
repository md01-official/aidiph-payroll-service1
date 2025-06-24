package com.aidiph.api.aidiph_payroll_service.repository;

import com.aidiph.api.aidiph_payroll_service.dto.Request.SalaryStructureComponentRequest;
import com.aidiph.api.aidiph_payroll_service.entity.SalaryStructureComponentEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SalaryStructureComponentRepository extends JpaRepository<SalaryStructureComponentEntity, UUID> {
    boolean existsByStructureCodeAndComponentCode(String structureCode, String componentCode);

    List<SalaryStructureComponentEntity> findByStructureCode(String structureCode);
}
