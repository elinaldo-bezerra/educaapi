package com.educacao.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

/**
 * @author eli
 */
@Document
public class Avaliacao {

    @Id
    private String id;
    private String name;
    private Double peso;    
    private Disciplina disciplina;
    private List<Bimestre> bimestres;

    public Avaliacao(String id, String name, Double peso, Disciplina disciplina, List<Bimestre> bimestres) {
        this.id = id;
        this.name = name;
        this.peso = peso;
        this.disciplina = disciplina;
        this.bimestres = bimestres;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Bimestre> getBimestres() {
        return bimestres;
    }

    public void setBimestres(List<Bimestre> bimestres) {
        this.bimestres = bimestres;
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
        final Avaliacao other = (Avaliacao) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "id=" + id + ", name=" + name + ", peso=" + peso + ", disciplina=" + disciplina + ", bimestres=" + bimestres + '}';
    }
    
    
 
}
    

 