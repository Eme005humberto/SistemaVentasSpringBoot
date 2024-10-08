package com.SistemaVentas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaVentas.Modelo.ClientesEntity;

public interface ClientesRepository extends JpaRepository<ClientesEntity,Integer>{
}
