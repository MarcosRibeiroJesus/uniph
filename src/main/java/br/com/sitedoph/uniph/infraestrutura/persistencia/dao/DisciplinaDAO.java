package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;

import br.com.sitedoph.uniph.dominio.entidade.Disciplina;
import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl.GenericDAOHibernate;

public class DisciplinaDAO {

	private final GenericDAO<Disciplina, Long> DAO;
	

	public DisciplinaDAO(EntityManager entityManager) {
		DAO = new GenericDAOHibernate<>(entityManager, Disciplina.class);
	}
	
	
	public void excluir(Disciplina entidade) {
		DAO.excluir(entidade);
	}

	public Disciplina salvarOuAtualizar(Disciplina entidade) {
		return DAO.salvarOuAtualizar(entidade);
	}

	public Disciplina buscarPorId(Long id) {
		return buscarPorId(id);

	}

	public List<Disciplina> buscarTodos() {
		return DAO.buscarTodos();
	}

}
