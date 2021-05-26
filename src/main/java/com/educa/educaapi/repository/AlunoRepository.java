package com.educa.educaapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.educa.educaapi.model.Aluno; 

@RepositoryRestResource(collectionResourceRel = "aluno", path = "alunos")
public interface AlunoRepository extends PagingAndSortingRepository<Aluno, Long> { 

}