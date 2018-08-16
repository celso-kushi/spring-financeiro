package br.com.kushi.financeiro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue
	private Long idUsuario;
	
	private String usuario;
	
	@JsonIgnore
	private String senha;
	
	@OneToMany(mappedBy="conta")
	private Set<Lancamento> lancamentos = new HashSet<>();
	
	private Conta() {}
	
	public Conta(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public Long getId() {
		return idUsuario;
	}

	public void setId(Long id) {
		this.idUsuario = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(Set<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
}
