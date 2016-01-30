package br.com.sitedoph.uniph.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TURMA")
public class Turma {

	@Id
	@GeneratedValue
	@Column(name = "CODIGO")
	private Long id;
	
	@ManyToMany(fetch = FetchType.LAZY)
}
