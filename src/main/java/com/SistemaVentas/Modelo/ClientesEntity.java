package com.SistemaVentas.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbtlclientes")
public class ClientesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClientes")
	private int idClientes;
	@Column(name = "nombreCompleto")
	private String nombreCompleto;
	
	public int getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(int idClientes) {
		this.idClientes = idClientes;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	
}
