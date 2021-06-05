package com.educa.educaapi.repository;

import com.educacao.api.model.Aluno;
import com.educacao.api.repository.AlunoRepository;
import com.mongodb.reactivestreams.client.MongoCollection;
import java.util.Collection;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class) 
@SpringBootTest
public class AlunoRepositoryTest {

    @Autowired
    AlunoRepository repository;

    @Autowired
    ReactiveMongoOperations operations;

    @Before
    public void setUp() {

        final Mono<MongoCollection<Document>> recreateCollection = operations.collectionExists(Aluno.class)
                .flatMap(exists -> exists ? operations.dropCollection(Aluno.class) : Mono.just(exists))
                .then(operations.createCollection(Aluno.class, CollectionOptions.empty()));

        StepVerifier.create(recreateCollection).expectNextCount(1).verifyComplete();

//        final Flux<Aluno> insertAll = operations.insertAll((Collection<? extends Aluno>) Flux.just(
//                        new Aluno("2", "2222", "ELIANA", "URL IMAGEM DE ELIANA", null),
//                        new Aluno("3", "3333", "ELOAH", "URL IMAGEM DE ELOAH", null)
//                ).collectList());

       // StepVerifier.create(insertAll).expectNextCount(3).verifyComplete();
    }

    @Test
    public void findOneByMatriculaShouldReturnOneAluno() {
        final Mono<Aluno> aluno = repository.findByMatricula("2222");
        StepVerifier.create(aluno)
                .expectNextCount(1l)
                .verifyComplete();
    }

    @Test
    public void findOneByInvalidMatriculahouldReturnEmpty() {
        final Mono<Aluno> product = repository.findByMatricula("123");
        StepVerifier.create(product)
                .expectNextCount(0l)
                .verifyComplete();
    }

//    @Test
//    public void findByMatriculaShouldReturnTwoAlunos() {
//        final Flux<Aluno> products = repository.findByMatricula(Mono.just("1111"));
//        StepVerifier.create(products)
//                .expectNextCount(2l)
//                .verifyComplete();
//    }

    @Test
    public void deleteAndFindOneProductShouldOk() {
        final Flux<Aluno> deleteAndFind
                = repository.deleteByMatricula("2222")
                        .thenMany(repository.findByMatricula("3333"));

        StepVerifier.create(deleteAndFind)
                .expectSubscription()
                .expectNextCount(0l)
                .expectComplete();
    }

    @Test
    public void saveNewAlunoShouldOk() {
//        final Mono<Aluno> newAluno = repository.save(
//                new Aluno("4", "4444", "MATHEUS", "URL IMAGEM DE MATHEUS", null));
//        StepVerifier.create(newAluno)
//                .expectNextCount(1)
//                .expectComplete();
    }

}
