package com.educacao.api.repository;

import com.educacao.api.model.Aluno;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author eli
 */
public interface AlunoRepository extends ReactiveCrudRepository<Aluno, String> {

    public Mono<Aluno> findByMatricula(String matricula);

    public Mono<Void> deleteByMatricula(String matricula);

}
