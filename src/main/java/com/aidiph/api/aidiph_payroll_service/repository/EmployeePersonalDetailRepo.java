package com.aidiph.api.aidiph_payroll_service.repository;

import com.aidiph.api.aidiph_payroll_service.entity.EmployeeDataEntity;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeePersonDetailEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeePersonalDetailRepo extends JpaRepository<EmployeePersonDetailEntity, UUID> {

    boolean existsById(UUID id);
}
