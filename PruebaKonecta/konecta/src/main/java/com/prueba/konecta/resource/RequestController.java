package com.prueba.konecta.resource;

import java.util.List;
import java.util.Optional;

import com.prueba.konecta.service.DTO.RequestDTO;
import com.prueba.konecta.service.mapper.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prueba.konecta.domain.Request;
import com.prueba.konecta.service.RequestService;

@RestController
@RequestMapping("api/requests")
public class RequestController {

	@Autowired
	private RequestService requestService;
	@Autowired
	private RequestMapper requestMapper;

	@CrossOrigin
	@PostMapping
	public ResponseEntity<?> create (@RequestBody RequestDTO requestDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(requestService.save(requestMapper.toEntity(requestDTO)));
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@PathVariable Long id, @RequestBody Request request){
		Optional<Request> requestOptional = requestService.findById(id);
		if(requestOptional.isPresent()){
			requestService.save(request);
			return ResponseEntity.ok().body(request);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		Optional<Request> requestOptional = requestService.findById(id);
		if(requestOptional.isPresent()){
			requestService.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long id){
		Optional<?> opSolicitud = requestService.findById(id);
		if(!opSolicitud.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(opSolicitud);
		}
	}

	@CrossOrigin
	@GetMapping()
	public ResponseEntity<List<RequestDTO>> readAll (){
		List<RequestDTO> requests = requestService.findAll();
		if(requests.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(requests);
		}
	}
	
}
