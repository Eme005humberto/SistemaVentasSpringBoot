package com.SistemaVentas.Negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SistemaVentas.Modelo.CategoriasEntity;
import com.SistemaVentas.Repository.CategoriasRepository;
@Service
public class CategoriaNegocio {

	@Autowired
	private CategoriasRepository service;
	
	//Traeremos la lista de categorias
	public List<CategoriasEntity> listaCategorias(){
		return service.findAll();
	}
	//Creamos una nueva categoria
	public CategoriasEntity crearCategoria(CategoriasEntity modelo) {
		return service.save(modelo);
	}
	//Buscamos una categoria por su Id
	public CategoriasEntity buscarPorId(int id) {
		return service.findById(id).orElse(null);
	}
	//Metodo para modificar una categoria
	public CategoriasEntity modificarCategoria(CategoriasEntity modelo,int id) {
		Optional<CategoriasEntity> categorias = service.findById(id);
		if(categorias.isPresent()) {
			CategoriasEntity categoria = new CategoriasEntity();
			categoria.setCategoria(modelo.getCategoria());
			categoria.setIdCategoria(modelo.getIdCategoria());
			return service.save(modelo);
		}else {
			throw new RuntimeException("No se encontro el id de la categoria" +id);
		}
	}
	//Metodo para eliminar una categoria
	public void eliminarCategoria(int id) {
		Optional<CategoriasEntity> categorias = service.findById(id);
		if(categorias.isPresent()) {
			service.deleteById(id);
		}else {
			throw new RuntimeException("No se encontro el id de la categoria" +id);
		}
	}
}
