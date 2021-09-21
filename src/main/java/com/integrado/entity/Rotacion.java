package com.integrado.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dvr_id",nullable=false)//es la llave foranea
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Dvr dvr;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="oficina_id",nullable=false)//es la llave foranea
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Oficina Oficina;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="rotacion_id")//esta clave se va ha crear en entregas
	private List<DetalleRotacion> detallerotacion;
	
	@JoinColumn(name="usuario_id",nullable=false) //campo de la llave foranea
	@JsonIgnoreProperties(value={"ventas","hibernateLazyInitializer", "handler"},allowSetters=true)
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt=new Date();
	}	
	
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
