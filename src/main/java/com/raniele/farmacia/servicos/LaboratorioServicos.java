package com.raniele.farmacia.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raniele.farmacia.entidades.Laboratorio;
import com.raniele.farmacia.excecoes.RecursoExistenteExcecao;
import com.raniele.farmacia.excecoes.RecursoNaoEncontradoExcecao;
import com.raniele.farmacia.repositorios.LaboratorioRepositorio;

@Service
public class LaboratorioServicos {

	@Autowired
	private LaboratorioRepositorio repositorio;

	public List<Laboratorio> findAll() { // encontrar todos
		return repositorio.findAll();
	}

	public Laboratorio findById(String id) { // encontrar por id
		return repositorio.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoExcecao("Laboratório não encontrado!"));
	}

	public Laboratorio criar(Laboratorio lab) { // criar um laboratório
		if (repositorio.existsById(lab.getCnpj())) {
			throw new RecursoExistenteExcecao("\"Já existe um laboratório com esse CNPJ.");
		}
		return repositorio.save(lab);

	}

	// atualizar laboratório
	public Laboratorio atualizar(String id, Laboratorio laboratorios) {

		Laboratorio entidade = repositorio.findById(id).orElseThrow(() -> new RecursoNaoEncontradoExcecao(
				"Laboratório não pode ser atualizado. Não encontrado no sistema."));

		if (laboratorios.getNome() != null) {
			entidade.setNome(laboratorios.getNome());
		}
		if (laboratorios.getEndereco() != null) {
			entidade.setEndereco(laboratorios.getEndereco());
		}
		if (laboratorios.getEmail() != null) {
			entidade.setEmail(laboratorios.getEmail());
		}
		if (laboratorios.getTelefone() != null) {
			entidade.setTelefone(laboratorios.getTelefone());
		}

		return repositorio.save(entidade);
	}

	public void delete(String id) { // deletar laboratório
		if (!repositorio.existsById(id)) {
			throw new RecursoNaoEncontradoExcecao("Esse laboratório não existe!");
		}
		repositorio.deleteById(id);
	}

}
