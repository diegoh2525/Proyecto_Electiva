package com.corhuila.electiva2.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedidos extends ABaseEntity{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleados empleadoId;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

	public Empleados getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(Empleados empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
