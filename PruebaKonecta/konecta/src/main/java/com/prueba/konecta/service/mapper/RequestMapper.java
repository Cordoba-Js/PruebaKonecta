package com.prueba.konecta.service.mapper;

import com.prueba.konecta.domain.Employee;
import com.prueba.konecta.domain.Request;
import com.prueba.konecta.service.DTO.RequestDTO;
import com.prueba.konecta.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RequestMapper {

    @Autowired
    private EmployeeService employeeService;

    public RequestDTO toDTO(Request request){
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setId(request.getId());
        requestDTO.setCode(request.getCode());
        requestDTO.setDescription(request.getDescription());
        requestDTO.setResume(request.getResume());
        requestDTO.setId_employee(request.getEmployee().getId());
        requestDTO.setEmployee_name(request.getEmployee().getName());
        return requestDTO;
    }

    public Request toEntity(RequestDTO requestDTO){
        Request request = new Request();

        request.setId(requestDTO.getId());
        request.setCode(requestDTO.getCode());
        request.setDescription(requestDTO.getDescription());
        request.setResume(requestDTO.getResume());
        Optional<Employee> employee = employeeService.findById(requestDTO.getId_employee());
        employee.ifPresent(request::setEmployee);

        return request;
    }
}
