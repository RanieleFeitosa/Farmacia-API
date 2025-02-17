package com.raniele.farmacia.excecoes;

public class RecursoNaoEncontradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontradoExcecao() {
		super();
	}

	public RecursoNaoEncontradoExcecao(String mensagem) {
		super(mensagem);
	}

}
