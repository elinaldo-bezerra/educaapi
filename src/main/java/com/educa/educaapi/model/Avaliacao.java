package com.educa.educaapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private float peso;

	@OneToMany(targetEntity = AlunoAvaliacao.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "avaliacao_id")
	private List<AlunoAvaliacao> alunoavaliacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public List<AlunoAvaliacao> getAlunoavaliacoes() {
		return alunoavaliacoes;
	}

	public void setAlunoavaliacoes(List<AlunoAvaliacao> alunoavaliacoes) {
		this.alunoavaliacoes = alunoavaliacoes;
	}

}