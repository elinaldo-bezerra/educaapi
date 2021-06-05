package com.educacao.api.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data; 

/**
 * @author eli
 */
@Document
@Data
@AllArgsConstructor
public class Aluno {

    @Id
    private String id;
    private String matricula;
    private String name;
    private String imagem;
    private Turma turma; 

}
