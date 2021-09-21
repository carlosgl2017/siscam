package com.integrado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.integrado.entity.Rotacion;

public interface RotacionRepository extends CrudRepository<Rotacion, Long> {
	List<Rotacion> findAll();
}
