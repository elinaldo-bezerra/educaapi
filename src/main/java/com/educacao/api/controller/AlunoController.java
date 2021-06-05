package com.educacao.api.controller;

import com.educacao.api.model.Aluno;
import com.educacao.api.service.AlunoService;
import java.time.Duration;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import reactor.core.publisher.Mono;

/**
 * @author eli
 */
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @Autowired
    public AlunoController(final AlunoService service) {
        this.service = service;
    }

    //FIND ALL 
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Flux<Aluno> findAll() {
        return service.findAll().delayElements(Duration.ofMillis(300));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Mono<Aluno> getAlunoById(@PathVariable String id) {
        return service.findById(id);
    }

    //FIND ONE BY MATRICULA
    @GetMapping("/matricula/{matricula}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Mono<Aluno> findOne(@PathVariable String matricula) {
        return service.findByMatricula(matricula);
    }

    //CREATE
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public Mono<Aluno> create(@Valid @RequestBody Aluno aluno) {
        return service.save(aluno);
    }

    //SAVE
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public Mono<Aluno> save(@Valid @RequestBody Aluno aluno) {
        return service.save(aluno);
    }

    //UPDATE
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Mono<Aluno> update(@Valid @RequestBody Mono<Aluno> aluno) {
        return aluno.flatMap(p -> service.save(p));
    }

    //DELETE ONE BY MATRICULA
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @CrossOrigin
    public Mono<Void> delete(@PathVariable String id) {
        return service.deleteById(id);
    }

}
