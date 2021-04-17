package com.prueba.konecta.service.mapper;


import com.prueba.konecta.domain.Employee;
import com.prueba.konecta.service.DTO.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employee.getId());
        employeeDTO.setEntry_date(employee.getEntry_date());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());

        return employeeDTO;
    }

}
