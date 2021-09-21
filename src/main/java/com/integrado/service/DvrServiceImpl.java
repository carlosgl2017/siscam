package com.integrado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrado.entity.Dvr;
import com.integrado.repository.DvrRepository;
@Service
public class DvrServiceImpl implements DvrService {
    @Autowired
	private DvrRepository dvrRepository;
    
	@Override
	@Transactional(readOnly = true)
	public List<Dvr> findAll() {
		return (List<Dvr>) dvrRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Dvr findById(Long id) {
		return dvrRepository.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public Dvr saveDvr(Dvr dvr) {
		return dvrRepository.save(dvr);
	}

	@Override
	@Transactional
	public void deleteDvrById(Long id) {
		dvrRepository.deleteById(id);		
		
	}

	
}
