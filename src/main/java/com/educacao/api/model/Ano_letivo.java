package com.educacao.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

/**
 * @author eli
 */
@Document
public class Ano_letivo {
    @Id
    private String id;
    private String name;        
    private Escola escola;    
    private List<Turma> turmas; 
    private List<Disciplina> disciplinas; 

    public Ano_letivo(String id, String name, Escola escola, List<Turma> turmas, List<Disciplina> disciplinas) {
        this.id = id;
        this.name = name;
        this.escola = escola;
        this.turmas = turmas;
        this.disciplinas = disciplinas;
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
 

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Ano_letivo other = (Ano_letivo) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Ano_letivo{" + "id=" + id + ", name=" + name + ", escola=" + escola + ", turmas=" + turmas + ", disciplinas=" + disciplinas + '}';
    }    
    
}
