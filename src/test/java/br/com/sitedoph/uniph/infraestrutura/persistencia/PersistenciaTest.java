package br.com.sitedoph.uniph.infraestrutura.persistencia;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class PersistenciaTest {

	@Test
	public void deveCriarOEntityManagerFactoryEEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uniph");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.close();
	}

}
