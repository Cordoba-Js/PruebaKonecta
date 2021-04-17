package com.prueba.konecta.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "solicitudes")
public class Request implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 50)
	private String code;
	@Column(length = 50)
	private String description;
	@Column(length = 50)
	private String resume;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_empleado", referencedColumnName = "id")
	private Employee employee;
	
	/*public Solicitud(Long id, String codigo, String descripcion, String resumen, int id_empleado) {
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.resumen = resumen;
		this.id_empleado = id_empleado;
	}*/

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String codigo) {
		this.code = codigo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descripcion) {
		this.description = descripcion;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resumen) {
		this.resume = resumen;
	}
	public Employee getEmpleado() {
		return employee;
	}
	public void setEmpleado(Employee employee_id) {
		this.employee = employee_id;
	}


}
