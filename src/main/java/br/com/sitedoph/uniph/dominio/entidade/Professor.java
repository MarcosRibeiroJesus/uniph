package br.com.sitedoph.uniph.dominio.entidade;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_PROFESSOR")
public class Professor {

	@Id
	@GeneratedValue
	@Column(name = "CODIGO")
	private Long id;

	@NotEmpty(message = "Preencha o nome completo!")
	@Size(min = 5)
	@Column(name = "NOME_COMPLETO")
	private String nomeCompleto;
	
	@CPF(message = "CPF inválido")
	@Column(name = "CPF")
	private String cpf;

	@Column(name = "TELEFONE")
	private String telefone;

	@NotEmpty(message = "Preencha o e-mail!")
    @Email(message = "Endereço de e-mail inválido")
	@Column(name = "EMAIL")
	private String email;

	
	@Column(name = "DT_CADASTRO") @Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDeCadastro;

	@Column(name = "CURRICULO", length = 5000)
	private String curriculo;
	
	

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

	
	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}


	

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
	
	 @Override
	    public String toString() {
	        return "Professor [" + (id != null ? "id=" + id + ", " : "")
	                + (nomeCompleto != null ? "nomeCompleto=" + nomeCompleto + ", " : "")
	                + (cpf != null ? "cpf=" + cpf + ", " : "") + (telefone != null ? "telefone=" + telefone + ", " : "")
	                + (email != null ? "email=" + email + ", " : "")
	                + (dataDeCadastro != null ? "dataDeCadastro=" + dataDeCadastro.getTime() + ", " : "")
	                + (curriculo != null ? "curriculo=" + curriculo : "") + "]";
	    }



	

}
