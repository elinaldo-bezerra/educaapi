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
public class AnoLetivo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@OneToMany(targetEntity = Bimestre.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "anoletivo_id")
	private List<Bimestre> bimestres;

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

	public List<Bimestre> getBimestres() {
		return bimestres;
	}

	public void setBimestres(List<Bimestre> bimestres) {
		this.bimestres = bimestres;
	}

}