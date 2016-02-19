package br.com.sitedoph.uniph.dominio.entidade.repositorio;

import java.util.List;
import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.ProfessorDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class ProfessorRepositorio {
	private EntityManager em;
	private ProfessorDAO DAO;

	private void criarDAOeEM() {
		em = JPAUtil.getEntityManager();
		DAO = new ProfessorDAO(em);
	}

	public Professor buscarPorId(Long id) {

		criarDAOeEM();

		Professor u = DAO.buscarPorId(id);

		em.close();

		return u;
	}

	public List<Professor> buscarTodos() {
		criarDAOeEM();

		List<Professor> lista = DAO.buscarTodos();

		em.close();

		return lista;
	}

	public void excluir(final Professor professor) {
		criarDAOeEM();

		em.getTransaction().begin();

		try {

			DAO.excluir(professor);
			em.getTransaction().commit();

		} catch (final Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}

	public Professor salvarOuAtualizar(Professor professor) {

		criarDAOeEM();

		em.getTransaction().begin();

		try {

			professor = DAO.salvarOuAtualizar(professor);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return professor;
	}
	
	public Professor buscarPorCPF(String cpf) {
		criarDAOeEM();
		
		Professor professor = DAO.buscarCPF(cpf);
		
		em.close();
		
		return professor;
		
	}
}
