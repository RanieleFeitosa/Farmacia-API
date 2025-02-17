package com.raniele.farmacia.excecoes;

public class RecursoExistenteExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoExistenteExcecao() {
		super();
	}

	public RecursoExistenteExcecao(String msg) {
		super(msg);
	}

}
