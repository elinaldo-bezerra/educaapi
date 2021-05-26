package com.educa.educaapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.educa.educaapi.model.Bimestre; 

@RepositoryRestResource(collectionResourceRel = "bimestre", path = "bimestres")
public interface BimestreRepository extends PagingAndSortingRepository<Bimestre, Long> { 

}