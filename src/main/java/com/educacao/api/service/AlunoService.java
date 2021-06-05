package com.educacao.api.service;

import com.educacao.api.model.Aluno;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** 
 * @author eli
 */
public interface AlunoService {

    Mono<Aluno> save(Aluno aluno);

    Mono<Aluno> findById(String id);

    Mono<Aluno> findByMatricula(String matricula);

    Mono<Void> deleteById(String id);

    Flux<Aluno> findAll();
}
