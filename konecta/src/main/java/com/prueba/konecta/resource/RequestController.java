package com.prueba.konecta.resource;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.prueba.konecta.domain.Request;
import com.prueba.konecta.service.RequestService;

public class RequestController {

	private RequestService requestService;
	
	// Crear nueva solicitud
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Request request){
		return ResponseEntity.status(HttpStatus.CREATED).body(requestService.save(request));
	}
	
	// Leer una solicitud
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long id){
		Optional<?> opSolicitud = requestService.findById(id);
		if(!opSolicitud.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(opSolicitud);
		}
	}
	
}
