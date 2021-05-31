package com.educacao.api.controller;

import com.educacao.api.exceptions.ExceptionsNotFoundException;
import com.educacao.api.model.Ano_letivo;
import com.educacao.api.service.AnoLetivoService;
import java.time.Duration;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eli
 */
@RestController
@RequestMapping("/api/anoletivo")
@Slf4j
public class AnoLetivoController {

    @Autowired
    private AnoLetivoService anoLetivoService;

    @Autowired
    public AnoLetivoController(final AnoLetivoService anoLetivoService) {
        this.anoLetivoService = anoLetivoService;
    }

    //CREATE
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public Mono<Ano_letivo> create(@Valid @RequestBody Ano_letivo anoletivo) {
        return anoLetivoService.save(anoletivo);
    }

    //SAVE
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public Mono<Ano_letivo> save(@Valid @RequestBody Ano_letivo ano_letivo) {
        return anoLetivoService.save(ano_letivo);
    }

    //UPDATE
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Mono<Ano_letivo> update(@Valid @RequestBody Mono<Ano_letivo> ano_letivo) {
        return ano_letivo.flatMap(p -> anoLetivoService.save(p));
    }

    //FIND ONE BY ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Mono<Ano_letivo> findOne(@PathVariable String id) {
        return anoLetivoService.findById(id)
                .switchIfEmpty(Mono.error(new ExceptionsNotFoundException("ano_letivo[%s].notFound", id)));
    }

    //DELETE ONE BY ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @CrossOrigin
    public Mono<Void> delete(@PathVariable String id) {
        return anoLetivoService.deleteById(id);
    }

    //FIND ALL
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Flux<Ano_letivo> findAll() {
        return anoLetivoService.findAll().delayElements(Duration.ofMillis(300));
    }
}
