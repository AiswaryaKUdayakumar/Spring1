package com.UST.EmployeePracticeCrud.repository;

import com.UST.EmployeePracticeCrud.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {
}

