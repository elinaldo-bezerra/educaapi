package com.educacao.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * @author eli
 */
@Document 
@Data
public class Bimestre {

    @Id
    private String id;
    private String name;
    private Integer dias_letivos;
    private Double peso;
    private Avaliacao avaliacoes; 
}
