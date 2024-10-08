package com.SistemaVentas.Negocio;

import com.SistemaVentas.Modelo.ProductosEntity;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SistemaVentas.Repository.ProductosRepository;
@Service
public class ProductosNegocio{

	@Autowired //Inyectamos el servicio
	private ProductosRepository service;
	
	//Traeremos todos los productos registrados en la base de datos
	public List<ProductosEntity> listarProductos(){
		return service.findAll();
	}
	
	//Crearemos un producto nuevo
	public ProductosEntity crearProducto(ProductosEntity modelo) {
		return service.save(modelo);
	}
	
	//Buscaremos un producto en especifico
	public ProductosEntity buscarPorId(int id) {
		return service.findById(id).orElse(null); //encontramos ese Id
	}
	
    //vamos a modificar el producto para ello vamos a obtener su Id
	public ProductosEntity modificarProducto(int id, ProductosEntity modelo) {
		Optional<ProductosEntity> producto = service.findById(id);
		if(producto.isPresent()) {
			ProductosEntity productos = new ProductosEntity();
			productos.setNombreProducto(modelo.getNombreProducto());
			productos.setPrecioUnitario(modelo.getPrecioUnitario());
			productos.setCantidad(modelo.getCantidad());
			productos.setIdCategoria(modelo.getIdCategoria());
			return service.save(modelo);
		}else {
			throw new RuntimeException("No se encontro el id del producto" +id);
		}
	}
	
	//eliminamos un producto por medio de su Id
	public void eliminarProducto(int id) {
		Optional<ProductosEntity> producto = service.findById(id);
		if(producto.isPresent()) {
			service.deleteById(id);
		}else {
			throw new RuntimeException("No se encontro el id del producto" +id);
		}
	}
}
