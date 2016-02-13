package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.UsuarioDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class UsuarioDAOTest {

	private static final String SENHA = "123456";
	private static final String MARQUINHOS = "marquinhos";

	@Test
	public void deveSalvar() {

		EntityManager em = JPAUtil.getEntityManager();

		UsuarioDAO dao = new UsuarioDAO(em);

		Usuario loginESenha = dao.buscarPorLoginESenha(MARQUINHOS, SENHA);

		em.getTransaction().begin();
		if (loginESenha != null) {
			dao.excluir(loginESenha);
		}
		em.getTransaction().commit();

		em.getTransaction().begin();

		Usuario mara = new Usuario();

		mara.setEmail("mara@mara.com");
		mara.setNomeCompleto("Mara");
		mara.setLogin(MARQUINHOS);
		mara.setSenha(SENHA);

		mara = dao.salvarOuAtualizar(mara);

		em.getTransaction().commit();

		Usuario buscarPorId = dao.buscarPorId(mara.getId());

		Assert.assertEquals(mara.getId(), buscarPorId.getId());
		Assert.assertEquals(mara.getEmail(), buscarPorId.getEmail());
		Assert.assertEquals(mara.getLogin(), buscarPorId.getLogin());
		Assert.assertEquals(mara.getNomeCompleto(), buscarPorId.getNomeCompleto());
		Assert.assertEquals(mara.getSenha(), buscarPorId.getSenha());

		List<Usuario> buscarTodos = dao.buscarTodos();

		for (Usuario usuario : buscarTodos) {
			System.out.println(usuario);
		}

		em.close();

	}

}