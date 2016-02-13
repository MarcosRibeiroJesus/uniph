package br.com.sitedoph.uniph.dominio.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TURMA")
public class Turma {

	@Id
	@GeneratedValue
	@Column(name = "CODIGO_TURMA")
	private Long id;
	
	@Column(name = "DESCRICAO")
    private String descricao;
	
	@Column(name = "DIAS_DA_SEMANA")
    private String diasDaSemana;
	
	@Column(name = "HORARIO")
    private String horario;

    @ManyToMany
    private List<Aluno> alunos;
    
    @ManyToMany
    private List<Disciplina> disciplinas;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(String diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	
}
