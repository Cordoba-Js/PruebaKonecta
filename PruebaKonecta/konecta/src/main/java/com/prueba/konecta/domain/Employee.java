package com.prueba.konecta.domain;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity()
@Table(name = "empleados")
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull
	private Date entry_date;

	@Column(length = 50)
	@NotNull
	private String name;
	@Column
	@NotNull
	private float salary;

	@OneToOne(mappedBy = "employee")
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
	public Request getRequest() {
		return this.request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	
	
}
