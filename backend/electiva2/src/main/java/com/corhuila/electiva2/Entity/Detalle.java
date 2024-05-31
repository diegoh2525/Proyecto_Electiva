package com.corhuila.electiva2.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle")
public class Detalle extends ABaseEntity{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedidos pedidoId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menuId;
	
	@Column(name = "cantidad", nullable = false)
    private Integer cantidad;
	
	@Column(name = "precio", nullable = false)
    private Double precio;

	public Pedidos getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Pedidos pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Menu getMenuId() {
		return menuId;
	}

	public void setMenuId(Menu menuId) {
		this.menuId = menuId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	

}