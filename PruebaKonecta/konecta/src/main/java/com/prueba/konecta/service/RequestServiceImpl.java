package com.prueba.konecta.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.prueba.konecta.service.DTO.RequestDTO;
import com.prueba.konecta.service.mapper.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.konecta.domain.Request;
import com.prueba.konecta.repository.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private RequestMapper requestMapper;

	@Override
	public List<RequestDTO> findAll() {
		// TODO Auto-generated method stub
		List<Request> requests = requestRepository.findAll();
		return requests.stream().map(request -> requestMapper.toDTO(request)).collect(Collectors.toList());
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
