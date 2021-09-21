package com.integrado.service;

import java.util.List;

import com.integrado.entity.Oficina;

public interface OficinaService {
	  public List<Oficina> findAll();
	  public Oficina findById(Long id);
	  public Oficina saveOficina(Oficina oficina);
	  public void deleteOficinaById(Long id);
}
