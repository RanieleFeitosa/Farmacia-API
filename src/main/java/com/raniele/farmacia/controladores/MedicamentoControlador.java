package com.raniele.farmacia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raniele.farmacia.entidades.Medicamento;
import com.raniele.farmacia.servicos.MedicamentoServicos;

@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentoControlador {

	@Autowired
	private MedicamentoServicos servico;

	@GetMapping // encontrar todos
	public ResponseEntity<List<Medicamento>> encontrarTodosOsMedicamentos() {
		return ResponseEntity.ok(servico.findAll());
	}

	@GetMapping("/{id}") // encontrar por id
	public ResponseEntity<Medicamento> encontrarMedicamentosPorId(@PathVariable Long id) {
		Medicamento med = servico.findById(id);
		return ResponseEntity.ok(med);
	}

	@PostMapping // criar um medicamento
	public ResponseEntity<Medicamento> criacao(@RequestBody Medicamento create) {
		Medicamento novoMedicamento = servico.criar(create);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoMedicamento);
	}

	@PatchMapping("/{id}") // atualizar um medicamento
	public ResponseEntity<Medicamento> atualizar(@PathVariable Long id, @RequestBody Medicamento atualizar) {
		Medicamento novoMedicamento = servico.atualizacao(id, atualizar);
		return ResponseEntity.ok().body(novoMedicamento);
	}

	@DeleteMapping("/{id}") // deletar um medicamento
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		servico.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
