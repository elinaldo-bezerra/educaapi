package com.educacao.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/** 
 * @author eli 
 */
@Document
@Data
public class Aluno {
    @Id
    private String id;
    private String matricula;
    private String name;
    private String imagem;    
    private Turma turma;    
}
