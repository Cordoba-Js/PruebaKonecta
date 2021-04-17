package com.prueba.konecta.service;

import java.util.List;
import java.util.Optional;

import com.prueba.konecta.service.DTO.RequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.konecta.domain.Request;


public interface RequestService {

	public List<RequestDTO> findAll();
	public Optional<Request> findById(Long id);
	public Request save(Request request);
	public void deleteById(Long id);
	
}
