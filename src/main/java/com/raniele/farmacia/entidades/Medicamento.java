package com.raniele.farmacia.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Medicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String lote;

	@Column(nullable = false)
	private LocalDate fabricacao;

	@Column(nullable = false)
	private LocalDate validade;

	@Column(nullable = false)
	private Double precoDeCusto;

	@Column(nullable = false)
	private Double precoDeVenda;

	@Column(nullable = false)
	private Integer quantidade;

	@ManyToOne
	@JoinColumn(nullable = true)
	private Laboratorio laboratorio;

	public Medicamento() {

	}

	public Medicamento(String nome, String lote, LocalDate fabricacao, LocalDate validade, Double precoDeCusto,
			Double precoDeVenda, Integer quantidade, Laboratorio laboratorio) {
		this.nome = nome;
		this.lote = lote;
		this.fabricacao = fabricacao;
		this.validade = validade;
		this.precoDeCusto = precoDeCusto;
		this.precoDeVenda = precoDeVenda;
		this.quantidade = quantidade;
		this.laboratorio = laboratorio;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public LocalDate getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(LocalDate fabricacao) {
		this.fabricacao = fabricacao;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Double getPrecoDeCusto() {
		return precoDeCusto;
	}

	public void setPrecoDeCusto(Double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}

	public Double getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(Double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

}
