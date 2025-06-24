package com.aidiph.api.aidiph_payroll_service.repository;

import com.aidiph.api.aidiph_payroll_service.dto.Request.EmployeeDataRequest;
import com.aidiph.api.aidiph_payroll_service.entity.EmployeeDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeDataEntity, UUID> {
}
