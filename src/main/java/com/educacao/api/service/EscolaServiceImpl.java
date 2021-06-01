package com.educacao.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.educacao.api.model.Escola;
import com.educacao.api.repository.EscolaRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eli 
 */
@Component
public class EscolaServiceImpl implements EscolaService {

    private final EscolaRepository escolaRepository;

    @Autowired
    public EscolaServiceImpl(EscolaRepository repository) {
        this.escolaRepository = repository;
    }

    @Override
    public Mono<Escola> save(Escola anoletivo) {
        return escolaRepository.save(anoletivo);
    }

    @Override
    public Flux<Escola> findAll() {
        return escolaRepository.findAll();
    }

    @Override
    public Mono<Escola> findById(String id) {
        return escolaRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return escolaRepository.deleteById(id);
    }

}
