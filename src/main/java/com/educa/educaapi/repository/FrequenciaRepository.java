package com.educa.educaapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.educa.educaapi.model.Frequencia; 

@RepositoryRestResource(collectionResourceRel = "frequencia", path = "Frequencias")
public interface FrequenciaRepository extends PagingAndSortingRepository<Frequencia, Long> { 

}