package com.educacao.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import lombok.Data;

/**
 * @author eli 
 */
@Document
@Data
public class Disciplina {

    @Id
    private String id;
    private String name;
    private Ano_letivo ano_letivo;
    private List<Avaliacao> avaliacoes;
}
    

 