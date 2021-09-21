package com.integrado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrado.entity.Oficina;
import com.integrado.repository.OficinaRepository;

@Service
public class OficinaServiceImpl implements OficinaService {

	@Autowired
	private OficinaRepository oficinaRepository;
	
	@Override
	public List<Oficina> findAll() {
		return (List<Oficina>) oficinaRepository.findAll();
	}

	@Override
	public Oficina findById(Long id) {
		return oficinaRepository.findById(id).orElseGet(null);
	}

	@Override
	public Oficina saveOficina(Oficina oficina) {
		return oficinaRepository.save(oficina);
	}

	@Override
	public void deleteOficinaById(Long id) {
		oficinaRepository.deleteById(id);		
	}

}
