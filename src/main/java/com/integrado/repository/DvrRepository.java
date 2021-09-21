package com.integrado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.integrado.entity.Dvr;

public interface DvrRepository extends CrudRepository<Dvr, Long> {
	List<Dvr> findAll();	
}
