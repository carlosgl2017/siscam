package com.integrado.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dvr", schema = "public")
public class dvr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddvr;
	private String codigoactivo;
	private String marca;
	private String modelo;
	private String descripcion;
	
	public Long getIddvr() {
		return iddvr;
	}
	public void setIddvr(Long iddvr) {
		this.iddvr = iddvr;
	}
	public String getCodigoactivo() {
		return codigoactivo;
	}
	public void setCodigoactivo(String codigoactivo) {
		this.codigoactivo = codigoactivo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
	
	
	
