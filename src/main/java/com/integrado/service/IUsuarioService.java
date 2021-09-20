package com.integrado.service;

import java.util.List;

import com.integrado.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
	public List<Usuario> findAll();
	public Usuario findById(Long id);
}
