package com.educacao.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

/**
 * @author eli 
 */
@Document
public class Disciplina {

    @Id
    private String id;
    private String name;
    private Ano_letivo ano_letivo;
    private List<Avaliacao> avaliacoes;

    public Disciplina(String id, String name, Ano_letivo ano_letivo, List<Avaliacao> avaliacoes) {
        this.id = id;
        this.name = name;
        this.ano_letivo = ano_letivo;
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

    public Ano_letivo getAno_letivo() {
        return ano_letivo;
    }

    public void setAno_letivo(Ano_letivo ano_letivo) {
        this.ano_letivo = ano_letivo;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Disciplina other = (Disciplina) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Disciplina{" + "id=" + id + ", name=" + name + ", ano_letivo=" + ano_letivo + ", avaliacoes=" + avaliacoes + '}';
    }
}
    

 