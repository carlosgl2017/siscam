package com.integrado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrado.entity.Disco;
import com.integrado.repository.DiscoRepository;

@Service
public class DiscoServiceImpl implements DiscoService {

	@Autowired
	private DiscoRepository discoRepository;
	
	@Override
	public List<Disco> findAll() {
		return (List<Disco>) discoRepository.findAll();
	}

	@Override
	public Disco findById(Long id) {
		return discoRepository.findById(id).orElseGet(null);
	}

	@Override
	public Disco saveDisco(Disco disco) {
		return discoRepository.save(disco);
	}

	@Override
	public void deleteDiscoById(Long id) {
		discoRepository.deleteById(id);			
	}

}
