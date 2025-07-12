package com.raniele.farmacia.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecursoExistenteExcecao.class)
	private ResponseEntity<String> recursoExistenteHandler(RecursoExistenteExcecao recurso) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(recurso.getMessage());
	}

	@ExceptionHandler(RecursoNaoEncontradoExcecao.class)
	private ResponseEntity<String> recursoNaoEncontradoHandler(RecursoNaoEncontradoExcecao recurso) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(recurso.getMessage());
	}

	@ExceptionHandler(PrecoInvalidoExcecao.class)
	private ResponseEntity<String> precoInvalidoHandler(PrecoInvalidoExcecao preco) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(preco.getMessage());
	}

	@ExceptionHandler(QuantidadeNegativaExcecao.class)
	private ResponseEntity<String> quantidadeNegativaHandler(QuantidadeNegativaExcecao quantidade) {
		return ResponseEntity.badRequest().body(quantidade.getMessage());
	}

	@ExceptionHandler(DatasInvalidasExcecao.class)
	private ResponseEntity<String> datasInvalidasHandler(DatasInvalidasExcecao datas) {
		return ResponseEntity.badRequest().body(datas.getMessage());
	}

}
