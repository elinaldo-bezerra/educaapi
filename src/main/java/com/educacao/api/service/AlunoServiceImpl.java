package com.educacao.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.educacao.api.model.Aluno;

import com.educacao.api.repository.AlunoRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eli
 */
@Component
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoServiceImpl(AlunoRepository repository) {
        this.alunoRepository = repository;
    }

    @Override
    public Mono<Aluno> save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Flux<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Mono<Aluno> findByMatricula(String matricula) {
        return alunoRepository.findByMatricula(matricula);
    }

    @Override
    public Mono<Void> deleteByMatricula(String matricula) {
        return alunoRepository.deleteByMatricula(matricula);
    }

}
