package br.com.sitedoph.uniph.dominio.entidade.repositorio;

import java.util.List;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;
import junit.framework.Assert;
//pertence ao domínio 
public class UsuarioRepositorioTest {
	private static final String LOGIN = "LOGAN";
    private static final String SENHA = "SENHAM";
	
	@Test
	public void deveFuncionarORepositorio(){
		UsuarioRepositorio repo = new UsuarioRepositorio();
		
		Usuario buscarPorloginESenha = repo.buscarPorLoginESenha(LOGIN, SENHA);
	
			
			if (buscarPorloginESenha !=null) {
				repo.excluir(buscarPorloginESenha);
				
			}
			Usuario Marcos = new Usuario();
			Marcos.setEmail(email);
			Marcos.setLogin(LOGIN);
			Marcos.setSenha(SENHA);
			
			Marcos = repo.salvarOuAtualizar(Marcos);
			
			Usuario buscarPorId = repo.buscarPorId(Marcos.getId());
			
			Assert.assertEquals(Marcos.getLogin(), buscarPorId.getLogin());
			Assert.assertEquals(Marcos.getSenha(), buscarPorId.getSenha());
			
			List<Usuario> buscarTodos = dao.buscarTodos();

			for (Usuario usuario : buscarTodos) {
				System.out.println(usuario);
			}

	}			

		
}
