package com.prueba.konecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.konecta.domain.Request;

public interface RequestRepository extends JpaRepository<Request,Long>{

}
