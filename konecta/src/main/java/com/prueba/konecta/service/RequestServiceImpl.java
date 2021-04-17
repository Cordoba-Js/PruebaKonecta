package com.prueba.konecta.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.konecta.domain.Request;
import com.prueba.konecta.repository.RequestRepository;

public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestRepository requestRepository;

	@Override
	public Iterable<Request> findAll() {
		// TODO Auto-generated method stub
		return requestRepository.findAll();
	}

	@Override
	public Page<Request> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return requestRepository.findAll(pageable) ;
	}

	@Override
	public Optional<Request> findById(Long id) {
		// TODO Auto-generated method stub
		return requestRepository.findById(id);
	}

	@Override
	public Request save(Request request) {
		// TODO Auto-generated method stub
		return requestRepository.save(request);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		requestRepository.deleteById(id);
	}

}
