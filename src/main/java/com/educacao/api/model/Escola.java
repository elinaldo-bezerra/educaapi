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
public class Escola { 
    @Id
    private String id;
    private String name;
    private String imagem;
    private List<Ano_letivo> anosletivos;          
}
