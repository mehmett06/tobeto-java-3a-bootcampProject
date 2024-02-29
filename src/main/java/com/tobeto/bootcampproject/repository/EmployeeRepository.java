package com.tobeto.bootcampproject.repository;

import com.tobeto.bootcampproject.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
