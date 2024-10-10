package com.SistemaVentas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaVentas.Modelo.CategoriasEntity;
import com.SistemaVentas.Negocio.CategoriaNegocio;

@RequestMapping("/Categorias")
@RestController
public class CategoriasController {
	
	@Autowired
	private CategoriaNegocio service;
	
	@GetMapping
	public List<CategoriasEntity> listarCategorias(){
		return service.listaCategorias();
	}
	
	@GetMapping("/Categorias/{id}")
	public CategoriasEntity buscarCategorias(@PathVariable int id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping("/Guardar")
	public CategoriasEntity agregarCategoria(CategoriasEntity modelo) {
		return service.crearCategoria(modelo);
	}
	
	@PutMapping("/Modificar/{id}")
	public CategoriasEntity modificarCategoria(@PathVariable int id,CategoriasEntity modelo) {
		return service.modificarCategoria(modelo, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarCategoria(@PathVariable int id) {
		service.eliminarCategoria(id);
		return "Categoria eliminada con exito!!!";
	}
}
