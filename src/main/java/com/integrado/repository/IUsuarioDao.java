package com.integrado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.integrado.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	public Usuario findByUsername(String username);
	/* para tener una consulta customizada query en spring jpa se tiene mas ejemplos*/
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username);
	
	List<Usuario> findAll();	
}
