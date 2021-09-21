package com.integrado.service;

import java.util.List;

import com.integrado.entity.Rotacion;

public interface RotacionService {
	 public List<Rotacion> findAll();
	  public Rotacion findById(Long id);
	  public Rotacion saveRotacion(Rotacion rotacion);
	  public void deleteRotacionById(Long id);
}
