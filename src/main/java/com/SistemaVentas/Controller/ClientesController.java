package com.SistemaVentas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaVentas.Modelo.ClientesEntity;
import com.SistemaVentas.Negocio.ClientesNegocio;

@RequestMapping("/Clientes")
@RestController
public class ClientesController {
	
	@Autowired
	private ClientesNegocio clientes;
	
	//Vamos a traer la lista de todos los clientes
	@GetMapping
	public List<ClientesEntity> listar(){
		return clientes.listarClientes();
	}
	//Vamos a invocar al metodo que nos sirve para guardar un cliente
	@PostMapping("/guardarClientes")
	public ClientesEntity guardar(@RequestBody ClientesEntity modelo) {
		return clientes.guardarCliente(modelo);
	}
	//Vamos a invocar el metodo para modificar un cliente
	@PutMapping("/modificarClientes/{id}")
	public ClientesEntity modificar(@RequestBody ClientesEntity modelo,@PathVariable int id) {
		return clientes.modificarCliente(modelo, id);
	}
	//Vamos a invocar el metodo para eliminar un cliente
	@DeleteMapping("/eliminarClientes/{id}")
	public String eliminar(@PathVariable int id) {
		clientes.eliminarCliente(id);
		return "Cliente eliminado exitosamente!!";
	}
	//Buscamos un cliente por su Id
	@GetMapping("/clientes/{id}")
	public ClientesEntity buscarCliente(@PathVariable int id) {
		return clientes.buscarPorId(id);
	}
}
