package com.SistemaVentas.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbtlventas")
public class VentasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVenta")
	private int idVenta;
	@Column(name = "idCliente")
	private int idCliente;
	@Column(name = "idProducto")
	private int idProducto;
	@Column(name = "precioUnitario")
	private float precioUnitario;
	@Column(name = "pagoProducto")
	private float pagoProducto;
	@Column(name = "totalPagar")
	private float totalPagar;
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public float getPagoProducto() {
		return pagoProducto;
	}
	public void setPagoProducto(float pagoProducto) {
		this.pagoProducto = pagoProducto;
	}
	public float getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(float totalPagar) {
		this.totalPagar = totalPagar;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
