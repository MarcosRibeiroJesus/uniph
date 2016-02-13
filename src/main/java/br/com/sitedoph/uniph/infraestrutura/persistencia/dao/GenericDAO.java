package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDAO <T, ID extends Serializable>{
	//CRUD 
	//Criar ou Atualizar
	/**
	 * Salva ou atyualiza qualquer entidade
	 * 
	 * @param entidade
	 * @return
	 */
	T salvarOuAtualizar (T entidade);
	
	/**
	 * Recupera a entidade por ID
	 * 
	 * @param id
	 * @return
	 */
	//Ler
	T buscarPorId(ID id);
	List<T> buscarTodos();
	
	//Atualizar = Criar
	
	/**
	 * Exclui a entidade
	 * 
	 * @param entidade
	 */
	//Excluir
	void excluir(T entidade);
	
	/**
	 * Recebe várias criterias e as utiliza para fazer uma pesquisa em banco de dados
	 * retornando uma lista de entidades
	 * 
	 * (... = vararg)
	 *  
	 * @param criteria
	 * @return
	 */
	//Outros métodos úteis:
	List<T> buscarPorCriteria(Criterion... criteria);
	
	
	/**
	 * Recebe uma instancia de exemplo e N string com propriedades que não serão 
	 * utilizadas na consulta.
	 * 
	 * Retorna um conjunto de entidades que sejam parecidas com o exemplo.
	 * 
	 * @param exemplo
	 * @param prorpiedadesAExcluir
	 * @return
	 */
	List<T> buscarPorExemplo(T exemplo, String... propriedadesAExcluir);
}
