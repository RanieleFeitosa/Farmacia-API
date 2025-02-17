package com.raniele.farmacia.excecoes;

public class DatasInvalidasExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatasInvalidasExcecao() {
		super();
	}

	public DatasInvalidasExcecao(String mensagem) {
		super(mensagem);
	}

}
