package br.com.sitedoph.uniph.dominio.entidade;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno {

	@Id
	@GeneratedValue
	@Column(name = "MATRICULA")
	private Long id;

	@Column(name = "NOME_COMPLETO")
	@NotBlank(message = "Preencha o nome completo!")
	private String nomeCompleto;

	@Column(name = "RG")
	private String rg;

	@CPF(message = "CPF inv�lido")
	@NotBlank(message = "Preencha o CPF!")
	@Column(name = "CPF")
	private String cpf;

	@Column(name = "DATA_NASCIMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDeNascimento;

	@Column(name = "TELEFONE")
	private String telefone;

	@NotBlank(message = "Preencha o e-mail!")
	@Email(message = "Endere�o de e-mail inv�lido")
	@Column(name = "EMAIL")
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CADASTRO")
	private Calendar dataDeCadastro;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "SEXO")
	private Sexo sexo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public Sexo getSexo() {

		return sexo;
	}

	public void setSexo(Sexo sexo) {

		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Aluno [" + (id != null ? "id=" + id + ", " : "")
				+ (nomeCompleto != null ? "nomeCompleto=" + nomeCompleto + ", " : "")
				+ (rg != null ? "rg=" + rg + ", " : "") + (cpf != null ? "cpf=" + cpf + ", " : "")
				+ (dataDeNascimento != null ? "dataDeNascimento=" + dataDeNascimento.getTime() + ", " : "")
				+ (telefone != null ? "telefone=" + telefone + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (dataDeCadastro != null ? "dataDeCadastro=" + dataDeCadastro.getTime() + ", " : "")
				+ (sexo != null ? "sexo=" + sexo : "") + "]";
	}

}
