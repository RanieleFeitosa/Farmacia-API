package com.raniele.farmacia.servicos;

import java.util.List;
import java.util.Optional;

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

	public List<Laboratorio> findAll() {
		return repositorio.findAll();
	}

	public Optional<Laboratorio> findById(String id) {
		return repositorio.findById(id);
	}

	public Laboratorio save(Laboratorio lab) {
		if (repositorio.existsById(lab.getCnpj())) {
			throw new RecursoExistenteExcecao("Esse laboratório já foi cadastrado !");
		}
		return repositorio.save(lab);

	}

	public Laboratorio atualizar(String id, Laboratorio laboratorios) {

		Laboratorio entidade = repositorio.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoExcecao("Laboratorio não encontrado!"));

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

	public void delete(String id) {
		if (!repositorio.existsById(id)) {
			throw new RecursoNaoEncontradoExcecao("Esse laboratório não existe!");
		}
		repositorio.deleteById(id);
	}

}
