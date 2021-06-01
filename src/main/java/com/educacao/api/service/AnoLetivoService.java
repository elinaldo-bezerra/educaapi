package com.educacao.api.service;

import com.educacao.api.model.Ano_letivo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eli
 */
public interface AnoLetivoService {
 
    Mono<Ano_letivo> save(Ano_letivo anoLetivo);

    Mono<Ano_letivo> findById(String id);

    Mono<Void> deleteById(String id);

    Flux<Ano_letivo> findAll();
}
