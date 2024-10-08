package com.SistemaVentas.Negocio;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaVentas.Modelo.ClientesEntity;
import com.SistemaVentas.Repository.ClientesRepository;


@Service
public class ClientesNegocio{
	@Autowired
	private ClientesRepository service;
	
	public List<ClientesEntity> listarClientes(){
		return service.findAll();
	}
	public ClientesEntity guardarCliente(ClientesEntity model) {
		return service.save(model);
	}
	
	public ClientesEntity buscarPorId(int id) {
		return service.findById(id).orElse(null);
	}
	
	public ClientesEntity modificarCliente(ClientesEntity model,int id) {
		Optional<ClientesEntity> cliente = service.findById(id);
		if(cliente.isPresent()) {
			ClientesEntity clientes = cliente.get();
			clientes.setNombreCompleto(model.getNombreCompleto());
			clientes.setIdClientes(model.getIdClientes());
			return service.save(clientes);
		}else {
			throw new RuntimeException("No se encontro el id del cliente" +id);
		}
	}
	
	public void eliminarCliente(int id) {
		Optional<ClientesEntity> cliente = service.findById(id);
		if(cliente.isPresent()) {
			service.deleteById(id);
		}else {
			throw new RuntimeException("No se encontro el id del cliente "+id);
		}
	}
}
