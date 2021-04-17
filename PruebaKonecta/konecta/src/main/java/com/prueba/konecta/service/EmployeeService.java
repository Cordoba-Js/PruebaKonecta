package com.prueba.konecta.service;

import java.util.List;
import java.util.Optional;

import com.prueba.konecta.service.DTO.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.konecta.domain.Employee;

public interface EmployeeService {
	public List<EmployeeDTO> findAll();
	public Optional<Employee> findById(Long id);
	public Employee save(Employee employee);
	public void deleteById(Long id);
	
}
