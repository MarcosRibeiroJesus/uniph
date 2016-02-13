package br.com.sitedoph.uniph.dominio.entidade;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.com.sitedoph.uniph.infraestrutura.validacao.util.ValidadorUtil;

public class UsuarioTest {

	public void deveValidar(){
		
		Validator validador = ValidadorUtil.getValidator();
		
		Usuario xpto = new Usuario();
		
		Set<ConstraintViolation<Usuario>> validate = validador.validate(xpto);
	}
}
