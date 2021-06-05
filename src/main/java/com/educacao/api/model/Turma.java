package com.educacao.api.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * @author eli
 */
@Document
@Data
public class Turma { 

    @Id
    private String id;
    private String name;
    private Ano_letivo ano_letivo;
    private List<Aluno> alunos; 
}
