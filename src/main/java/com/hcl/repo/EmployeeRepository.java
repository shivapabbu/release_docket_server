package com.hcl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
