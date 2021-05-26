package com.educa.educaapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.educa.educaapi.model.AlunoAvaliacao;

@RepositoryRestResource(collectionResourceRel = "alunoavaliacao", path = "alunoavaliacoes")
public interface AlunoAvaliacaoRepository extends PagingAndSortingRepository<AlunoAvaliacao, Long> {

}