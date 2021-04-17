package com.prueba.konecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.konecta.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
