package com.corhuila.electiva2.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu extends ABaseEntity{
	
	@Column(name = "nombre_plato", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 50, nullable = false)
    private String descripcion;
    
    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "categoria", length = 50, nullable = false)
    private String categoria;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
    

}
