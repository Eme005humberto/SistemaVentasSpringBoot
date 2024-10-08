package com.SistemaVentas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaVentas.Modelo.ProductosEntity;

public interface ProductosRepository extends JpaRepository<ProductosEntity,Integer>{

}
