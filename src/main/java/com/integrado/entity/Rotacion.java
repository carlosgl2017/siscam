package com.integrado.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rotaciones", schema = "public")
public class Rotacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrotacion;
	private String observacion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaini;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechafin;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechahoracambio;
	public Long getIdrotacion() {
		return idrotacion;
	}
	public void setIdrotacion(Long idrotacion) {
		this.idrotacion = idrotacion;
	}
	
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Date getFechaini() {
		return fechaini;
	}
	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	public Date getFechahoracambio() {
		return fechahoracambio;
	}
	public void setFechahoracambio(Date fechahoracambio) {
		this.fechahoracambio = fechahoracambio;
	}
	
	
}
