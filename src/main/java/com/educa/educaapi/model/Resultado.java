package com.educa.educaapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	private float media_primeiro;
	
	private float media_segundo;
	
	private float media_terceiro;
	
	private float media_quarto;

	private float mediafinal;
	
	private String resultadofinal;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 

	public String getResultadofinal() {
		return resultadofinal;
	}

	public void setResultadofinal(String resultadofinal) {
		this.resultadofinal = resultadofinal;
	}

	public float getMedia_primeiro() {
		return media_primeiro;
	}

	public void setMedia_primeiro(float media_primeiro) {
		this.media_primeiro = media_primeiro;
	}

	public float getMedia_segundo() {
		return media_segundo;
	}

	public void setMedia_segundo(float media_segundo) {
		this.media_segundo = media_segundo;
	}

	public float getMedia_terceiro() {
		return media_terceiro;
	}

	public void setMedia_terceiro(float media_terceiro) {
		this.media_terceiro = media_terceiro;
	}

	public float getMedia_quarto() {
		return media_quarto;
	}

	public void setMedia_quarto(float media_quarto) {
		this.media_quarto = media_quarto;
	}

	public float getMediafinal() {
		return mediafinal;
	}

	public void setMediafinal(float mediafinal) {
		this.mediafinal = mediafinal;
	}
	 

}