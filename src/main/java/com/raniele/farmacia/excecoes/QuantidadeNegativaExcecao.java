package com.raniele.farmacia.excecoes;

public class QuantidadeNegativaExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QuantidadeNegativaExcecao() {
		super();
	}

	public QuantidadeNegativaExcecao(String mensagem) {
		super(mensagem);
	}

}
