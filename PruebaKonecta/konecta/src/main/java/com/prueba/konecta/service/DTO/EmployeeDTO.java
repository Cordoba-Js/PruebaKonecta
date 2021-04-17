package com.prueba.konecta.service.DTO;

import com.prueba.konecta.domain.Request;

import java.util.Date;

public class EmployeeDTO {
    private Long id;
    private Date entry_date;
    private String name;
    private float salary;
    private Request request;

	/*public Empleado(Long id, Date fecha_ingreso, String nombre, float salario) {
		this.id = id;
		this.fecha_ingreso = fecha_ingreso;
		this.nombre = nombre;
		this.salario = salario;
	}*/

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getEntry_date() {
        return entry_date;
    }
    public void setEntry_date(Date fecha_ingreso) {
        this.entry_date = fecha_ingreso;
    }
    public String getName() {
        return name;
    }
    public void setName(String nombre) {
        this.name = nombre;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salario) {
        this.salary = salario;
    }
}
