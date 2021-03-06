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
@Table(name = "discos", schema = "public")
public class Disco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddisco;
	private Double capacidad;
	private String codigoactivo;
	private String descripcion;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt=new Date();
	}	
	
	public Long getIddisco() {
		return iddisco;
	}
	public void setIddisco(Long iddisco) {
		this.iddisco = iddisco;
	}
	public Double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Double capacidad) {
		this.capacidad = capacidad;
	}
	public String getCodigoactivo() {
		return codigoactivo;
	}
	public void setCodigoactivo(String codigoactivo) {
		this.codigoactivo = codigoactivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
