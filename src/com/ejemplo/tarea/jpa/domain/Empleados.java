package com.ejemplo.tarea.jpa.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_EMPLEADO")
public class Empleados {
	@Id
	@Column(name = "EMP_ID")
	private Long idemp;
	private String nombre;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "EmpleadosXProyectos", joinColumns = @JoinColumn(name = "idemp", referencedColumnName = "EMP_ID"), 
				inverseJoinColumns = @JoinColumn(name = "idpry", referencedColumnName = "PROY_ID"))
	private Collection<Proyectos> proyectos;

	public Empleados() {
		
	}

	public Empleados(Long idemp, String nombre, Collection<Proyectos> proyectos) {
		super();
		this.idemp = idemp;
		this.nombre = nombre;
		this.proyectos = proyectos;
	}

	public Long getIdemp() {
		return idemp;
	}

	public void setIdemp(Long idemp) {
		this.idemp = idemp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Proyectos> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Collection<Proyectos> proyectos) {
		this.proyectos = proyectos;
	}
}
