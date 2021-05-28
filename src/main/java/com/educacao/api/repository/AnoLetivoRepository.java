package com.educacao.api.repository;

import com.educacao.api.model.Ano_letivo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author eli
 */
public interface AnoLetivoRepository extends ReactiveCrudRepository<Ano_letivo, String> {

}
