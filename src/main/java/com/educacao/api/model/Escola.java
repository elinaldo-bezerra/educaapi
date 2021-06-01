package com.educacao.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

/**
 * @author eliboots
 */
@Document
public class Escola { 
    @Id
    private String id;
    private String name;
    private String imagem;
    private List<Ano_letivo> anosletivos; 

    public Escola(String id, String name, String imagem, List<Ano_letivo> anosletivos) {
        this.id = id;
        this.name = name;
        this.imagem = imagem;
        this.anosletivos = anosletivos;
    } 

    public Escola() {
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<Ano_letivo> getAnosletivos() {
        return anosletivos;
    }

    public void setAnosletivos(List<Ano_letivo> anosletivos) {
        this.anosletivos = anosletivos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Escola other = (Escola) obj;
        return Objects.equals(this.id, other.id);
    }
 

    @Override
    public String toString() {
        return "Escola{" + "id=" + id + ", name=" + name + ", imagem=" + imagem + ", anosletivos=" + anosletivos + '}';
    }
    
}
