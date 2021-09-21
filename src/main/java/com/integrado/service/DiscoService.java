package com.integrado.service;

import java.util.List;

import com.integrado.entity.Disco;

public interface DiscoService {
	  public List<Disco> findAll();
	  public Disco findById(Long id);
	  public Disco saveDisco(Disco dvr);
	  public void deleteDiscoById(Long id);
}
