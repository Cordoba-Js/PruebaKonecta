package com.prueba.konecta.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.prueba.konecta.service.DTO.EmployeeDTO;
import com.prueba.konecta.service.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.konecta.domain.Employee;
import com.prueba.konecta.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	//private EmployeeDTO EmployeeDTO;

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDTO> findAll(){
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();//employeesItDTO;
		return employees.stream().map(employee -> employeeMapper.toDTO(employee)).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
