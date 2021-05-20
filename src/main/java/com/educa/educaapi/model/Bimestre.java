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
public class Bimestre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private int diasletivos;

	@OneToMany(targetEntity = AlunoAvaliacao.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "bimestre_id")
	private List<AlunoAvaliacao> alunoavaliacoes;
	
	@OneToMany(targetEntity = Frequencia.class)
	@JoinColumn(name = "bimestre_id")
	private List<Frequencia> frequencias;  
	

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
 
	public int getDiasletivos() {
		return diasletivos;
	}

	public void setDiasletivos(int diasletivos) {
		this.diasletivos = diasletivos;
	}
 
	
	public List<AlunoAvaliacao> getAlunoavaliacoes() {
		return alunoavaliacoes;
	}

	public void setAlunoavaliacoes(List<AlunoAvaliacao> alunoavaliacoes) {
		this.alunoavaliacoes = alunoavaliacoes;
	}

	public List<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}
	
	

}