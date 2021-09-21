package com.integrado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.integrado.entity.Oficina;

public interface OficinaRepository extends CrudRepository<Oficina, Long> {
	List<Oficina> findAll();	
}
