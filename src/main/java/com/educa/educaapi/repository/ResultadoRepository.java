package com.educa.educaapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.educa.educaapi.model.Avaliacao; 

@RepositoryRestResource(collectionResourceRel = "avaliacao", path = "avaliacoes")
public interface ResultadoRepository extends PagingAndSortingRepository<Avaliacao, Long> { 

}