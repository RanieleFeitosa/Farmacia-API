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

import com.raniele.farmacia.entidades.Laboratorio;
import com.raniele.farmacia.servicos.LaboratorioServicos;

@RestController
@RequestMapping(value = "/laboratorios")
public class LaboratorioControlador {

	@Autowired
	private LaboratorioServicos servico;

	@GetMapping // encontrar todos
	public ResponseEntity<List<Laboratorio>> acharTodos() {
		return ResponseEntity.ok(servico.findAll());
	}

	@GetMapping("/{id}") // encontrar por id
	public ResponseEntity<Laboratorio> acharLaboratorioPorId(@PathVariable String id) {
		Laboratorio lab = servico.findById(id);
		return ResponseEntity.ok(lab);
	}

	@PostMapping // criar laboratório
	public ResponseEntity<Laboratorio> criacao(@RequestBody Laboratorio lab) {
		Laboratorio laboratorioCriado = servico.criar(lab);
		return ResponseEntity.status(HttpStatus.CREATED).body(laboratorioCriado);
	}

	@PatchMapping("/{id}") // atualizar laboratório
	public ResponseEntity<Laboratorio> atualizar(@PathVariable String id, @RequestBody Laboratorio atualizacao) {
		return ResponseEntity.ok(servico.atualizar(id, atualizacao));
	}

	@DeleteMapping("/{id}") // deletar laboratório
	public ResponseEntity<Void> deletar(@PathVariable String id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}

}
