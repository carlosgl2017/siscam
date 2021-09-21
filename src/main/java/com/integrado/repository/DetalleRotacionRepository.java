package com.integrado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.integrado.entity.DetalleRotacion;

public interface DetalleRotacionRepository extends CrudRepository<DetalleRotacion, Long>{
	List<DetalleRotacion> findAll();

}
