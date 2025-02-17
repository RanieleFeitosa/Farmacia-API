package com.raniele.farmacia.controladores;

import java.util.List;
import java.util.Optional;

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

	@GetMapping
	public ResponseEntity<List<Medicamento>> encontrarTodosOsMedicamentos() {
		return ResponseEntity.ok(servico.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> encontrarMedicamentosPorId(@PathVariable Long id) {
		Optional<Medicamento> med = servico.findById(id);

		if (med.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(med.get());
	}

	@PostMapping
	public ResponseEntity<Medicamento> salvar(@RequestBody Medicamento salvar) {
		Medicamento novoMedicamento = servico.salvar(salvar);

		return ResponseEntity.status(HttpStatus.CREATED).body(novoMedicamento);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Medicamento> atualizar(@PathVariable Long id, @RequestBody Medicamento atualizar) {
		if (servico.findById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Medicamento novoMedicamento = servico.atualizacao(id, atualizar);
		return ResponseEntity.ok().body(novoMedicamento);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (servico.findById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		servico.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
