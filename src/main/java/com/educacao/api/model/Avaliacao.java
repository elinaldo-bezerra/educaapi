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
public class Avaliacao {

    @Id    
    private String id;
    private String name;
    private Double peso;    
    private Disciplina disciplina;
    private List<Bimestre> bimestres;
}
    

 