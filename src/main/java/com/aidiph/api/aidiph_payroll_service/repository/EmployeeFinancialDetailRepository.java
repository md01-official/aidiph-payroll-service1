package com.aidiph.api.aidiph_payroll_service.repository;

import com.aidiph.api.aidiph_payroll_service.entity.EmployeeFinancialDetailEntity;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeFinancialDetailRepository extends JpaRepository<EmployeeFinancialDetailEntity, UUID> {
    boolean existsByAccountNumber(Long accountNumber);

    boolean existsByPanNumber(String panNumber);

    boolean existsByAadharNumber(Long aadharNumber);
}
