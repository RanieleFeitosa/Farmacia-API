package com.raniele.farmacia.servicos;

import java.util.List;
import java.util.Optional;

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

	public List<Medicamento> findAll() {
		return repositorio.findAll();
	}

	public Optional<Medicamento> findById(Long id) {
		return repositorio.findById(id);
	}

	public Medicamento salvar(Medicamento salvar) {

		if (salvar.getPrecoDeCusto() > salvar.getPrecoDeVenda()) {
			throw new PrecoInvalidoExcecao("Preço de custo não pode ser maior que preço de venda.");
		} else if (salvar.getPrecoDeVenda() <= 0) {
			throw new PrecoInvalidoExcecao("Preço de venda não pode ser estar zerado nem ser negativo.");
		} else if (salvar.getQuantidade() < 1) {
			throw new QuantidadeNegativaExcecao("O sistema não aceita que o campo quantidade esteja zerado.");
		} else if (salvar.getFabricacao().isAfter(salvar.getValidade())) {
			throw new DatasInvalidasExcecao("A data de fabricação não pode ser maior que a data de validade.");
		}

		return repositorio.save(salvar);
	}

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

	public void deletar(Long id) {
		if (!repositorio.existsById(id)) {
			throw new RecursoNaoEncontradoExcecao("Esse lote não existe!");
		}
		repositorio.deleteById(id);

	}

}
