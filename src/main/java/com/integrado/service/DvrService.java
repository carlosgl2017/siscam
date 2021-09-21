package com.integrado.service;

import java.util.List;

import com.integrado.entity.Dvr;

public interface DvrService {
  public List<Dvr> findAll();
  public Dvr findById(Long id);
  public Dvr saveDvr(Dvr dvr);
  public void deleteDvrById(Long id);
}
