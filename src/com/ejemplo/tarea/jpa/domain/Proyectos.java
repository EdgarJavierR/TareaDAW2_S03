package com.ejemplo.tarea.jpa.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_PROYECTO")
public class Proyectos {
	@Id
	@GeneratedValue
	@Column(name = "PROY_ID")
	private Long idpry;
	private String nombre;
	@ManyToMany(mappedBy = "proyectos")
	private Collection<Empleados> empleados;

	public Proyectos() {

	}

	public Proyectos(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Long getIdpry() {
		return idpry;
	}

	public void setIdpry(Long idpry) {
		this.idpry = idpry;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Empleados> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Collection<Empleados> empleados) {
		this.empleados = empleados;
	}

}
