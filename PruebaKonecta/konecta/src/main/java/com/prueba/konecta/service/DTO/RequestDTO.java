package com.prueba.konecta.service.DTO;

import java.io.Serializable;

public class RequestDTO implements Serializable {
        private Long id;
        private String code;
        private String description;
        private String resume;
        private Long id_employee;
        private String employee_name;

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
            return this.code;
        }
        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() { return this.description; }
        public void setDescription(String description) {
            this.description = description;
        }

        public String getResume() {
            return this.resume;
        }
        public void setResume(String resume) {
            this.resume = resume;
        }

        public Long getId_employee() {
            return id_employee;
        }
        public void setId_employee(Long id_employee) {
            this.id_employee = id_employee;
        }

        public String getEmployee_name() {
            return employee_name;
        }
        public void setEmployee_name(String employee_name) {
            this.employee_name = employee_name;
        }

}
