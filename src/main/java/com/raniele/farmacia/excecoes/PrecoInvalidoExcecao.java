package com.raniele.farmacia.excecoes;

public class PrecoInvalidoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PrecoInvalidoExcecao() {
		super();
	}

	public PrecoInvalidoExcecao(String mensagem) {
		super(mensagem);
	}

}
