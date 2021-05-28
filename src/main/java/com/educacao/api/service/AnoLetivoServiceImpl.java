package com.educacao.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.educacao.api.model.Ano_letivo;
import com.educacao.api.repository.AnoLetivoRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eli
 */
@Component
public class AnoLetivoServiceImpl implements AnoLetivoService {

    private final AnoLetivoRepository anoLetivoRepository;

    @Autowired
    public AnoLetivoServiceImpl(AnoLetivoRepository repository) {
        this.anoLetivoRepository = repository;
    }

    @Override
    public Mono<Ano_letivo> save(Ano_letivo anoletivo) {
        return anoLetivoRepository.save(anoletivo);
    }

    @Override
    public Flux<Ano_letivo> findAll() {
        return anoLetivoRepository.findAll();
    }

    @Override
    public Mono<Ano_letivo> findById(String id) {
        return anoLetivoRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return anoLetivoRepository.deleteById(id);
    }

}
