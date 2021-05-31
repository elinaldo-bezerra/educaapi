package com.educacao.api.service;

import com.educacao.api.model.Escola;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eli
 */
public interface EscolaService {

    Mono<Escola> save(Escola escola);

    Mono<Escola> findById(String id);

    Mono<Void> deleteById(String id);

    Flux<Escola> findAll();
}
