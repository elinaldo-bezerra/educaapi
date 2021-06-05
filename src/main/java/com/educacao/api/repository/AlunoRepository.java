package com.educacao.api.repository;

import com.educacao.api.model.Aluno;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eli
 */
public interface AlunoRepository extends ReactiveCrudRepository<Aluno, String> {

    public Mono<Aluno> findByMatricula(String matricula);

    public Flux<Aluno> findByName(String name);

    public Mono<Void> deleteById(String id);

}
