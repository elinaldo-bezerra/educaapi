package com.educacao.api.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

/**
 * @author eli
 */
@Document
public class Turma { 

    @Id
    private String id;
    private String name;
    private Ano_letivo ano_letivo;
    private List<Aluno> alunos;

    public Turma(String id, String name, Ano_letivo ano_letivo, List<Aluno> alunos) {
        this.id = id;
        this.name = name;
        this.ano_letivo = ano_letivo;
        this.alunos = alunos;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Turma other = (Turma) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Turma{" + "id=" + id + ", name=" + name + ", ano_letivo=" + ano_letivo + ", alunos=" + alunos + '}';
    }
    
 
}
