package com.educacao.api.controller;

import com.educacao.api.exceptions.ExceptionsNotFoundException;
import com.educacao.api.model.Aluno;
import com.educacao.api.service.AlunoService;
import java.time.Duration;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eli
 */
@RestController
@RequestMapping("/api/aluno")
@Slf4j
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    public AlunoController(final AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    //CREATE
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Aluno> create(@Valid @RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    //SAVE
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Aluno> save(@Valid @RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    //UPDATE
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Aluno> update(@Valid @RequestBody Mono<Aluno> aluno) {
        return aluno.flatMap(p -> alunoService.save(p));
    }

    //FIND ONE BY MATRICULA
    @GetMapping("/{matricula}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Aluno> findOne(@PathVariable String matricula) {
        return alunoService.findByMatricula(matricula)
                .switchIfEmpty(Mono.error(new ExceptionsNotFoundException("Aluno[%s].notFound", matricula)));
    }

    //DELETE ONE BY MATRICULA
    @DeleteMapping("/{matricula}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> delete(@PathVariable String matricula) {
        return alunoService.deleteByMatricula(matricula);
    }

    //FIND ALL
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Aluno> findAll() {
        return alunoService.findAll().delayElements(Duration.ofMillis(300));
    }
//
//    @GetMapping(value = "/lista")
//    public List<Aluno> getAllAlunos() {
//        return alunoService.findAll();
//    }
//
//    @GetMapping(value = "/{matricula}")
//    public Aluno getAlunoMatricula(@PathVariable("matricula") String matricula) {
//        return alunoService.findByMatricula(matricula);
//    }

//    @GetMapping(value = "/orderByname")
//    public List<Aluno> findAllOrderName() {
//        return alunoService.findAllOrderName();
//    }
//    @PostMapping(value = "/save")
//    public ResponseEntity<Aluno> saveOrUpdateAluno(@RequestBody Aluno aluno) {
//        alunoService.saveOrUpdateAluno(aluno);
//        return new ResponseEntity("Aluno adicionado com sucesso!", HttpStatus.OK);
//    }
//    @DeleteMapping(value = "/delete/{matricula}")
//    public ResponseEntity<Aluno> deleteAlunoByMatricula(@PathVariable String matricula) {
//        alunoService.deleteAlunoById(alunoService.findByMatricula(matricula).getId());
//        return new ResponseEntity("Aluno removido com sucesso!", HttpStatus.OK);
//    }
}
