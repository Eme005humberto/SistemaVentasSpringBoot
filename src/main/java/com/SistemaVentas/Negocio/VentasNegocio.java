package com.SistemaVentas.Negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaVentas.Modelo.VentasEntity;
import com.SistemaVentas.Repository.VentasRepository;
@Service
public class VentasNegocio {

	@Autowired
	private VentasRepository service;
	
	public List<VentasEntity> listarVentas() {
		return service.findAll();
	}
	
	public float CalcularVenta(VentasEntity modelo) {
		float resultado;
		resultado = modelo.getPagoProducto() - modelo.getPrecioUnitario();
		return resultado;
	}
	
	public VentasEntity guardarVenta(VentasEntity modelo) {
		return service.save(modelo);
	}
	
	public VentasEntity buscarPorId(int id) {
		return service.findById(id).orElse(null);
	}
	
	public VentasEntity modificarVenta(VentasEntity modelo,int id) {
		Optional<VentasEntity> ventas = service.findById(id);
		if(ventas.isPresent()) {
			VentasEntity venta = new VentasEntity();
			venta.setIdCliente(modelo.getIdCliente());
			venta.setPrecioUnitario(modelo.getPrecioUnitario());
			venta.setPagoProducto(modelo.getPagoProducto());
			venta.setTotalPagar(modelo.getTotalPagar());
			venta.setIdVenta(modelo.getIdVenta());
			return service.save(venta);
		}else {
			throw new RuntimeException("No se encontro el id de la venta" +id);
		}
	}
	
	public void eliminarVenta(int id) {
		Optional<VentasEntity> ventas = service.findById(id);
		if(ventas.isPresent()) {
			service.deleteById(id);
		}else {
			throw new RuntimeException("No se encontro el id de la venta" +id);
		}
	}
}
