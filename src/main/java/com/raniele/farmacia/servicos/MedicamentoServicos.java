package com.raniele.farmacia.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raniele.farmacia.entidades.Medicamento;
import com.raniele.farmacia.excecoes.DatasInvalidasExcecao;
import com.raniele.farmacia.excecoes.PrecoInvalidoExcecao;
import com.raniele.farmacia.excecoes.QuantidadeNegativaExcecao;
import com.raniele.farmacia.excecoes.RecursoNaoEncontradoExcecao;
import com.raniele.farmacia.repositorios.MedicamentoRepositorio;

@Service
public class MedicamentoServicos {

	@Autowired
	private MedicamentoRepositorio repositorio;

	public List<Medicamento> findAll() { // encontrar todos
		return repositorio.findAll();
	}

	public Medicamento findById(Long id) { // encontrar por id
		return repositorio.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoExcecao("Medicamento não encontrado!"));
	}

	public Medicamento criar(Medicamento create) { // criar um medicamento

		if (create.getPrecoDeCusto() > create.getPrecoDeVenda()) {
			throw new PrecoInvalidoExcecao("Preço de custo não pode ser maior que preço de venda.");
		} else if (create.getPrecoDeVenda() <= 0) {
			throw new PrecoInvalidoExcecao("Preço de venda não pode ser estar zerado nem ser negativo.");
		} else if (create.getQuantidade() < 1) {
			throw new QuantidadeNegativaExcecao("O sistema não aceita que o campo quantidade esteja zerado.");
		} else if (create.getFabricacao().isAfter(create.getValidade())) {
			throw new DatasInvalidasExcecao("A data de fabricação não pode ser maior que a data de validade.");
		}

		return repositorio.save(create);
	}

	// atualizar medicamentos
	public Medicamento atualizacao(Long id, Medicamento medicamento) {

		Medicamento entidade = repositorio.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoExcecao("Medicamento não encontrado!"));

		if (medicamento.getNome() != null) {
			entidade.setNome(medicamento.getNome());
		}
		if (medicamento.getLote() != null) {
			entidade.setLote(medicamento.getLote());
		}
		if (medicamento.getFabricacao() != null) {
			entidade.setFabricacao(medicamento.getFabricacao());
		}
		if (medicamento.getValidade() != null) {
			entidade.setValidade(medicamento.getValidade());
		}
		if (medicamento.getPrecoDeCusto() != null) {
			entidade.setPrecoDeCusto(medicamento.getPrecoDeCusto());
		}
		if (medicamento.getPrecoDeVenda() != null) {
			entidade.setPrecoDeVenda(medicamento.getPrecoDeVenda());
		}
		if (medicamento.getQuantidade() != null) {
			entidade.setQuantidade(medicamento.getQuantidade());
		}
		if (medicamento.getLaboratorio() != null) {
			entidade.setLaboratorio(medicamento.getLaboratorio());
		}

		return repositorio.save(entidade);
	}

	public void deletar(Long id) { // deletar medicamentos
		if (!repositorio.existsById(id)) {
			throw new RecursoNaoEncontradoExcecao("Esse lote não existe!");
		}
		repositorio.deleteById(id);

	}

}
