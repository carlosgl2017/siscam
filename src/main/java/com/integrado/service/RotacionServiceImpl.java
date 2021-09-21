package com.integrado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrado.entity.Rotacion;
import com.integrado.repository.RotacionRepository;

@Service
public class RotacionServiceImpl implements RotacionService {

	@Autowired
	private RotacionRepository rotacionRepository;

	@Override
	public List<Rotacion> findAll() {
		return (List<Rotacion>) rotacionRepository.findAll();
	}

	@Override
	public Rotacion findById(Long id) {
		return rotacionRepository.findById(id).orElseGet(null);
	}

	@Override
	public Rotacion saveRotacion(Rotacion rotacion) {
		return rotacionRepository.save(rotacion);
	}

	@Override
	public void deleteRotacionById(Long id) {
		rotacionRepository.deleteById(id);
	}

}
