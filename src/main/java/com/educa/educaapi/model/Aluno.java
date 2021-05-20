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
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String matricula;

	private String nome;

	@OneToMany(targetEntity = AlunoAvaliacao.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "aluno_id")
	private List<AlunoAvaliacao> alunoavaliacoes;
	
	@OneToMany(targetEntity = Resultado.class)
	@JoinColumn(name = "aluno_id")
	private List<Resultado> resultados;
	
	@OneToMany(targetEntity = Frequencia.class)
	@JoinColumn(name = "aluno_id")
	private List<Frequencia> frequencias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

  
	
	public List<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public List<AlunoAvaliacao> getAlunoavaliacoes() {
		return alunoavaliacoes;
	}

	public void setAlunoavaliacoes(List<AlunoAvaliacao> alunoavaliacoes) {
		this.alunoavaliacoes = alunoavaliacoes;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	 
}
