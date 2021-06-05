package com.educacao.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/** 
 * @author eli
 */
@Document
@Data
public class Ano_letivo {
    @Id
    private String id;
    private String name;        
    private Escola escola;    
    private List<Turma> turmas; 
    private List<Disciplina> disciplinas; 
}
