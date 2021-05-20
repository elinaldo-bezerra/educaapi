package com.educa.educaapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.educa.educaapi.model.Resultado; 

@RepositoryRestResource(collectionResourceRel = "resultado", path = "resultados")
public interface AvaliacaoRepository extends PagingAndSortingRepository<Resultado, Long> { 

}