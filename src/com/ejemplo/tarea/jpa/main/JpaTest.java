package com.ejemplo.tarea.jpa.main;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ejemplo.tarea.jpa.domain.Empleados;
import com.ejemplo.tarea.jpa.domain.Proyectos;

public class JpaTest {
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager em = factory.createEntityManager();
		JpaTest test = new JpaTest(em);
		EntityTransaction tr = em.getTransaction();
		tr.begin();
			test.crearProyectosDesdeUnEmpleado();
		tr.commit();
	}
	
	private void crearProyectosDesdeUnEmpleado() {
		Empleados emp1 = manager.find(Empleados.class, new Long(1));
		Proyectos pry1 = new Proyectos("Marketing");
		Proyectos pry2 = new Proyectos("Comercios");
		List<Proyectos> proyectos = Arrays.asList(pry1,pry2);
		emp1.setProyectos(proyectos);
		manager.persist(emp1);
	}
}
