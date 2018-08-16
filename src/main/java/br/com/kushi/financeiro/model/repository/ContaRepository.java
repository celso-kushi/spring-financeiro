package br.com.kushi.financeiro.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kushi.financeiro.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	Optional<Conta> findByUsuario(String usuario);

}
