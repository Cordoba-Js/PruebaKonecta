package com.prueba.konecta.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.konecta.domain.Request;


public interface RequestService {

	public Iterable<Request> findAll();
	public Page<Request> findAll(Pageable pageable);
	public Optional<Request> findById(Long id);
	public Request save(Request request);
	public void deleteById(Long id);
	
}
