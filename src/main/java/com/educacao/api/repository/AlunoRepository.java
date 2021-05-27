package com.educacao.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educacao.api.model.Aluno;

import java.util.List;

/**
 * @author eli 
 */ 
public interface AlunoRepository extends MongoRepository<Aluno, String> {

    Aluno findByMatricula(String matricula);

//    List<Aluno> findAllOrderName();
}