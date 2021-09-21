package com.integrado.entity;

import java.io.Serializable;
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
@Table(name = "oficinas", schema = "public")
public class Oficina implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2543904189132210105L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idoficina;	
	private String oficina;
	private String descripcion;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt=new Date();
	}

	public Long getIdoficina() {
		return idoficina;
	}

	public void setIdoficina(Long idoficina) {
		this.idoficina = idoficina;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}	
	
	
	
	
}
