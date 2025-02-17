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

import com.raniele.farmacia.entidades.Laboratorio;
import com.raniele.farmacia.servicos.LaboratorioServicos;

@RestController
@RequestMapping(value = "/laboratorios")
public class LaboratorioControlador {

	@Autowired
	private LaboratorioServicos servico;

	@GetMapping
	public ResponseEntity<List<Laboratorio>> acharTodos() {
		return ResponseEntity.ok(servico.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Laboratorio> acharLaboratorioPorId(@PathVariable String id) {
		Optional<Laboratorio> lab = servico.findById(id);

		if (lab.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(lab.get());
	}

	@PostMapping
	public ResponseEntity<Laboratorio> salvar(@RequestBody Laboratorio lab) {
		Laboratorio laboratorioSalvo = servico.save(lab);
		return ResponseEntity.status(HttpStatus.CREATED).body(laboratorioSalvo);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Laboratorio> atualizar(@PathVariable String id, @RequestBody Laboratorio atualizacao) {
		if (servico.findById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(servico.atualizar(id, atualizacao));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable String id) {
		if (servico.findById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}

}
