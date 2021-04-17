package com.prueba.konecta.service.mapper;

import com.prueba.konecta.domain.Request;
import com.prueba.konecta.service.DTO.RequestDTO;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper {

    public RequestDTO tuDTO(Request request){
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setId(request.getId());
        requestDTO.setCodigo(request.getCode());
        requestDTO.setDescripcion(request.getDescription());
        requestDTO.setResumen(request.getResume());
        requestDTO.setEmployee_name(request.getEmpleado().getName());
        return requestDTO;
    }
}
