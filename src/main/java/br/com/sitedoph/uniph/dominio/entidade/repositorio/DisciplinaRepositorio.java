package br.com.sitedoph.uniph.dominio.entidade.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Disciplina;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.DisciplinaDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class DisciplinaRepositorio {
	
	private EntityManager em;
	private DisciplinaDAO DAO;

	private void criarDAOeEM() {
		em = JPAUtil.getEntityManager();
		DAO = new DisciplinaDAO(em);
	}

	public Disciplina buscarPorId(Long id) {

		criarDAOeEM();

		Disciplina u = DAO.buscarPorId(id);

		em.close();

		return u;
	}
	
	public List<Disciplina> buscarTodos() {
		criarDAOeEM();

		List<Disciplina> lista = DAO.buscarTodos();

		em.close();

		return lista;
	}

	public void excluir(final Disciplina disciplina) {
		criarDAOeEM();

		em.getTransaction().begin();

		try {

			DAO.excluir(disciplina);
			em.getTransaction().commit();

		} catch (final Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
	}

	public Disciplina salvarOuAtualizar(Disciplina disciplina) {

		criarDAOeEM();

		em.getTransaction().begin();

		try {

			disciplina = DAO.salvarOuAtualizar(disciplina);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return disciplina;
	}
	
	public Disciplina buscarPorDescricao(String descricao) {

        criarDAOeEM();

        Disciplina u = DAO.buscarPorDescricao(descricao);

        em.close();

        return u;
    }

}


