package com.prueba.konecta.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.konecta.domain.Employee;
import com.prueba.konecta.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmpleadoController {
	@Autowired
	private EmployeeService empleadoService;
	/*public EmpleadoController(EmpleadoService empleadoService){
		this.empleadoService = empleadoService;
	}*/

	// Crear nuevo empleado
	@PostMapping()
	public ResponseEntity<?> create (@RequestBody Employee employee){
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(employee));
	}
	
	// consultar un empleado
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id){
		Optional<?> opEmployee = empleadoService.findById(id);
		if(!opEmployee.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(opEmployee);
		}
	}
	@GetMapping()
	public ResponseEntity<List<Employee>> readAll (Model model){
		Iterable<Employee> employeesIt = empleadoService.findAll();
		List<Employee> employeesList = new ArrayList((Collection) employeesIt);
		if(employeesList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(employeesList);
		}
	}
}
