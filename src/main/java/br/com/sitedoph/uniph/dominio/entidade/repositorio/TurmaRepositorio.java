package br.com.sitedoph.uniph.dominio.entidade.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Turma;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.TurmaDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class TurmaRepositorio {

	private EntityManager em;
	private TurmaDAO DAO;

	private void criarDAOeEM() {
		em = JPAUtil.getEntityManager();
		DAO = new TurmaDAO(em);
	}

	public Turma buscarPorId(Long id) {

		criarDAOeEM();

		Turma u = DAO.buscarPorId(id);

		em.close();

		return u;
	}
	
	public List<Turma> buscarTodos() {
		criarDAOeEM();

		List<Turma> lista = DAO.buscarTodos();

		em.close();

		return lista;
	}

	public void excluir(final Turma turma) {
		criarDAOeEM();

		em.getTransaction().begin();

		try {

			DAO.excluir(turma);
			em.getTransaction().commit();

		} catch (final Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
	}

	public Turma salvarOuAtualizar(Turma turma) {

		criarDAOeEM();

		em.getTransaction().begin();

		try {

			turma = DAO.salvarOuAtualizar(turma);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return turma;
	}
	
	public Turma buscarPorDescricao(String turma) {

        criarDAOeEM();

        Turma u = DAO.buscarPorDescricao(turma);

        em.close();

        return u;
    }

}

