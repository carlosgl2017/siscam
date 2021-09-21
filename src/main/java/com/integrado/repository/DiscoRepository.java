package com.integrado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.integrado.entity.Disco;

public interface DiscoRepository extends CrudRepository<Disco, Long>{
	List<Disco> findAll();
}
