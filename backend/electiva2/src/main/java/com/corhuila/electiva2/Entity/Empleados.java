package com.corhuila.electiva2.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleados extends ABaseEntity{
	
	@Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;
    
    @Column(name = "puesto", length = 50, nullable = false)
    private String puesto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
    

}
