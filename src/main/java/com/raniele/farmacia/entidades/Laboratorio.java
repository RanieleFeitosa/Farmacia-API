package com.raniele.farmacia.entidades;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Laboratorio {

	@Id
	private String cnpj;

	@Column(nullable = false, unique = true)
	private String nome;

	private String endereco;

	private String email;

	private String telefone;

	@JsonIgnore
	@OneToMany(mappedBy = "laboratorio")
	private Set<Medicamento> medicamentos = new HashSet<>();

	public Laboratorio() {

	}

	public Laboratorio(String cnpj, String nome, String endereco, String email, String telefone) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Medicamento> getMedicamentos() {
		return medicamentos;
	}

}
