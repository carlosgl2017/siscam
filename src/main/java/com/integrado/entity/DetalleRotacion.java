package com.integrado.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detallerotacion", schema = "public")
public class DetalleRotacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetallerotacion;
	
}
