package com.integrado.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dvr", schema = "public")
public class Dvr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddvr;
	private String codigoactivo;
	private String marca;
	private String modelo;
	private String descripcion;	
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt=new Date();
	}	
	
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
	
	
	
