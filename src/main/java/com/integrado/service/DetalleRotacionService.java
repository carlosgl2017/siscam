package com.integrado.service;

import java.util.List;

import com.integrado.entity.DetalleRotacion;

public interface DetalleRotacionService {
	public List<DetalleRotacion> findAll();
	  public DetalleRotacion findById(Long id);
	  public DetalleRotacion saveDetalleRotacion(DetalleRotacion detallerotacion);
	  public void deleteDetalleRotacionById(Long id);
}
