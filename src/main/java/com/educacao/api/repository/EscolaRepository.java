package com.educacao.api.repository;

import com.educacao.api.model.Escola;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author eli
 */
public interface EscolaRepository extends ReactiveCrudRepository<Escola, String> {

}
 