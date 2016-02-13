package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.AlunoDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.UsuarioDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class AlunoDAOTest {
	
	private static final String CPF = "999.999.999-99";
	
	@Test
	public void deveSalvar() {

		EntityManager em = JPAUtil.getEntityManager();

		AlunoDAO dao = new AlunoDAO(em);
		
		Aluno alunoPorCPF = dao.buscarCPF(99999999999);
		
		em.getTransaction().begin();
		if (cpf != null) {
			dao.excluir(cpf);
		}
		em.getTransaction().commit();

		em.getTransaction().begin();

		
}
