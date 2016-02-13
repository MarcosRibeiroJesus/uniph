package br.com.sitedoph.uniph.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_USUARIOS")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CODIGO")
	private Long id;
	
	
	@Column(name = "NOME_COMPLETO")
	private String nomeCompleto;
	
	@Email
	 @Column(name = "EMAIL", unique = true)
	 private String email;

	@NotBlank(message = "Não pode estar vazio")
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "SENHA")
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
    public String toString() {

        return "Usuario [email=" + email + ", id=" + id + ", login=" + login + ", nomeCompleto=" + nomeCompleto + ", senha=" + senha + "]";
    }

}


