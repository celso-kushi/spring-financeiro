package br.com.kushi.financeiro;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.kushi.financeiro.model.Conta;
import br.com.kushi.financeiro.model.Lancamento;
import br.com.kushi.financeiro.model.repository.ContaRepository;
import br.com.kushi.financeiro.model.repository.LancamentoRepository;

@SpringBootApplication
public class FinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceiroApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(ContaRepository contaRepository, LancamentoRepository lancamentoRepository) {
		
		return args -> 
		Arrays.asList("jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong")
				.forEach(usuario -> {
					Conta conta = contaRepository.save(new Conta(usuario, "senha"));
					lancamentoRepository.save(new Lancamento("Descrição 1", conta));
					lancamentoRepository.save(new Lancamento("Descrição 2", conta));
				});
	}
}
