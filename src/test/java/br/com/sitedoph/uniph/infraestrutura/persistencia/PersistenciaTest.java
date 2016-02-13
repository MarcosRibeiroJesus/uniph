package br.com.sitedoph.uniph.infraestrutura.persistencia;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class PersistenciaTest {

	@Test
	public void deveCriarOEntityManagerFactoryEEntityManager() {

		EntityManager em = JPAUtil.getEntityManager();

		em.close();
	}

	@Test
	public void devePersistirUmAluno() {

		EntityManager em = JPAUtil.getEntityManager();

		Aluno ze = new Aluno();

		ze.setNomeCompleto("José Roberto");
		ze.setCpf("999.999.999-99");
		ze.setDataDeCadastro(Calendar.getInstance());
		ze.setDataDeNascimento(Calendar.getInstance());
		ze.setEmail("ze@ze.com");
		ze.setRg("81818181");
		ze.setTelefone("61 81818181");

		em.getTransaction().begin();
		em.persist(ze);
		em.getTransaction().commit();

		// HQL
		Query query = em.createQuery("SELECT a FROM Aluno a");
		List<Aluno> list = query.getResultList();

		for (Aluno a : list) {
			final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println("Data de Cadastro = " + a.getNomeCompleto()+ "Data de Nascimento = " + df.format(a.getDataDeCadastro().getTime()));
		}
		em.close();
	}
}
