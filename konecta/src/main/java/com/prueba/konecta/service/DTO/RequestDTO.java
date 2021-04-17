package com.prueba.konecta.service.DTO;

import java.io.Serializable;

public class RequestDTO implements Serializable {
        private Long id;
        private String codigo;
        private String descripcion;
        private String resumen;
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

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }
        public String getDescripcion() {
            return descripcion;
        }
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getResumen() {
            return resumen;
        }

        public void setResumen(String resumen) {
            this.resumen = resumen;
        }

        public String getEmployee_name() {
            return employee_name;
        }
        public void setEmployee_name(String employee_name) {
            this.employee_name = employee_name;
        }

}
