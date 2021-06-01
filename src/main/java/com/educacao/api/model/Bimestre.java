package com.educacao.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

/**
 * @author eli
 */
@Document 
public class Bimestre {

    @Id
    private String id;
    private String name;
    private Integer dias_letivos;
    private Double peso;
    private Avaliacao avaliacoes;

    public Bimestre(String id, String name, Integer dias_letivos, Double peso, Avaliacao avaliacoes) {
        this.id = id;
        this.name = name;
        this.dias_letivos = dias_letivos;
        this.peso = peso;
        this.avaliacoes = avaliacoes;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDias_letivos() {
        return dias_letivos;
    }

    public void setDias_letivos(Integer dias_letivos) {
        this.dias_letivos = dias_letivos;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Avaliacao getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Avaliacao avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bimestre other = (Bimestre) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bimestre{" + "id=" + id + ", name=" + name + ", dias_letivos=" + dias_letivos + ", peso=" + peso + ", avaliacoes=" + avaliacoes + '}';
    }
 
}
