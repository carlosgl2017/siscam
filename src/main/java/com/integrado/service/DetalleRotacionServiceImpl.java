package com.integrado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrado.entity.DetalleRotacion;
import com.integrado.repository.DetalleRotacionRepository;

@Service
public class DetalleRotacionServiceImpl implements DetalleRotacionService {

	   @Autowired
		private DetalleRotacionRepository detalleRotacionRepository;
	   @Override
		@Transactional(readOnly = true)
	public List<DetalleRotacion> findAll() {
		return (List<DetalleRotacion>) detalleRotacionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleRotacion findById(Long id) {
		return detalleRotacionRepository.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public DetalleRotacion saveDetalleRotacion(DetalleRotacion detallerotacion) {
		return detalleRotacionRepository.save(detallerotacion);
	}

	@Override
	@Transactional
	public void deleteDetalleRotacionById(Long id) {
		detalleRotacionRepository.deleteById(id);		
	}
}
