package br.com.kushi.financeiro.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kushi.financeiro.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	
	Collection<Lancamento> findByContaUsuario(String usuario);

}
