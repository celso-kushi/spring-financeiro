package br.com.kushi.financeiro.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kushi.financeiro.model.Lancamento;
import br.com.kushi.financeiro.model.repository.ContaRepository;
import br.com.kushi.financeiro.model.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamentos/{usuario}")
public class LancamentoController {
	
	private LancamentoRepository lancamentoRepository;
	private ContaRepository contaRepository;

	@Autowired
	LancamentoController(LancamentoRepository lancamentoRepository, ContaRepository contaRepository) {
		this.lancamentoRepository = lancamentoRepository;
		this.contaRepository = contaRepository;
	}
	
	@GetMapping
	Collection<Lancamento> obterLancamentos(@PathVariable String usuario) throws Exception {
		this.validateUser(usuario);

		return this.lancamentoRepository.findByContaUsuario(usuario);
	}
	
	@GetMapping("/{idLancamento}")
	Lancamento readBookmark(@PathVariable String usuario, @PathVariable Long idLancamento) throws Exception {
		this.validateUser(usuario);

		return this.lancamentoRepository
			.findById(idLancamento)
			.orElseThrow(() -> new Exception("Não existe lançamento com este id: " + idLancamento));
	}
	
	/**
	 * Verify the {@literal usuario} exists.
	 *
	 * @param usuario
	 * @throws Exception 
	 */
	private void validateUser(String usuario) throws Exception {
		this.contaRepository
			.findByUsuario(usuario)
			.orElseThrow(() -> new Exception("Não existe o usuário: " + usuario));
	}
	
}
