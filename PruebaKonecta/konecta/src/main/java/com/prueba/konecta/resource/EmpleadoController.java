package com.prueba.konecta.resource;

import java.util.List;
import java.util.Optional;

import com.prueba.konecta.service.DTO.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	@CrossOrigin
	@PostMapping()
	public ResponseEntity<?> create (@RequestBody Employee employee){
		return ResponseEntity.ok().body(empleadoService.save(employee));
	}

	// Crear nuevo empleado
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@PathVariable Long id, @RequestBody Employee employee){
		Optional<Employee> employeeOptional = empleadoService.findById(id);
		if(employeeOptional.isPresent()){
			empleadoService.save(employee);
			return ResponseEntity.ok().body(employee);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Crear nuevo empleado
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		Optional<Employee> employeeOptional = empleadoService.findById(id);
		if(employeeOptional.isPresent()){
			empleadoService.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// consultar un empleado
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id){
		Optional<?> opEmployee = empleadoService.findById(id);
		if(!opEmployee.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(opEmployee);
		}
	}

	@CrossOrigin
	@GetMapping()
	public ResponseEntity<List<EmployeeDTO>> readAll (){
		List<EmployeeDTO> employees = empleadoService.findAll();
		if(employees.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(employees);
		}
	}
}
