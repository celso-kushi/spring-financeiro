package br.com.kushi.financeiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lancamento {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	@JsonIgnore
	@ManyToOne
	private Conta conta;
	
	private Lancamento() {}
	
	public Lancamento(String descricao, Conta conta) {
		this.descricao = descricao;
		this.conta = conta;
	}

	public static Lancamento from(Conta conta, Lancamento lancamento) {
		return new Lancamento(lancamento.getDescricao(), conta);		
	}
	
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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
