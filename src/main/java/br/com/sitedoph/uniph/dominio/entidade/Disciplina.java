package br.com.sitedoph.uniph.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DISCIPLINA")
public class Disciplina {
	
	@Id
	@GeneratedValue
	@Column(name = "CODIGO")
	private Long id;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@ManyToOne
	private Professor professor;
	
	@Column(name = "CARGA_HORARIA")
	private String nomeCompleto;

}
