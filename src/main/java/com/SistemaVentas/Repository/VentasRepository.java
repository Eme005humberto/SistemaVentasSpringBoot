package com.SistemaVentas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaVentas.Modelo.VentasEntity;

public interface VentasRepository extends JpaRepository<VentasEntity,Integer>{

}
