package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAO;

public class GenericDAOHibernate <T, ID extends Serializable >implements GenericDAO<T, ID> {
	
	private final Class<T> CLASSE;
	
	//Gerente de entidades
	private final EntityManager ENTITY_MANAGER;
	
	public GenericDAOHibernate(final EntityManager entityManager, final Class<T> classe ) {
		
		ENTITY_MANAGER = entityManager;
		CLASSE = classe;
	}

	@Override
	public T salvarOuAtualizar(T entidade) {
		
		return ENTITY_MANAGER.merge(entidade);
	}

	@Override
	public T buscarPorId(ID id) {
		
		return ENTITY_MANAGER.find(CLASSE, id);
	}

	@Override
	public List<T> buscarTodos() {
		
		final CriteriaQuery<T> query = 
				ENTITY_MANAGER.getCriteriaBuilder().createQuery(CLASSE);
		query.select(query.from(CLASSE));
		
		return ENTITY_MANAGER.createQuery(query).getResultList();
	}

	@Override
	public void excluir(T entidade) {
		
		ENTITY_MANAGER.merge(entidade);//caso o objeto esteja destacado é necessário executar o merge para trazê-lo 
		ENTITY_MANAGER.remove(entidade);
		
	}

	@Override
	public List<T> buscarPorCriteria(Criterion... criteria) {
		
		final Session session = getHibernateSession();
				
		final Criteria crit = session.createCriteria(CLASSE);
		
		for (Criterion criterion : criteria) {
			crit.add(criterion);
		}
				
		return crit.list();
	}

	private Session getHibernateSession() {
		final Session session = (Session) ENTITY_MANAGER.getDelegate();
		return session;
	}

	@Override
	public List<T> buscarPorExemplo(T exemplo, String... propriedadesAExcluir) {
		
		
		final Example example = Example.create(exemplo);
		
		example.enableLike(MatchMode.ANYWHERE);
		example.excludeZeroes();
		example.ignoreCase();
		
		for (String prop : propriedadesAExcluir) {

				example.excludeProperty(prop);
		}
		
		final Session session = getHibernateSession();
		
		final Criteria criteria = session.createCriteria(CLASSE).add(example);
		
		return criteria.list();

	}

	
}
