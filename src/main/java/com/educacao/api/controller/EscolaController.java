package com.educacao.api.controller;

import com.educacao.api.exceptions.ExceptionsNotFoundException;
import com.educacao.api.model.Escola;
import com.educacao.api.service.EscolaService;
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
@RequestMapping("/api/v1/escola")
@Slf4j
 
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @Autowired
    public EscolaController(final EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    //FIND ALL
    
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)     
    public Flux<Escola> findAll() {
        return escolaService.findAll().delayElements(Duration.ofMillis(300));
    }

    //CREATE
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public Mono<Escola> create(@Valid @RequestBody Escola escola) {
        return escolaService.save(escola);
    }

    //SAVE
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public Mono<Escola> save(@Valid @RequestBody Escola escola) {
        return escolaService.save(escola);
    }

    //UPDATE
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Mono<Escola> update(@Valid @RequestBody Escola escola) {
        return escolaService.save(escola);
    }

    //FIND ONE BY ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public Mono<Escola> findOne(@PathVariable String id) {
        return escolaService.findById(id)
                .switchIfEmpty(Mono.error(new ExceptionsNotFoundException("Escola[%s].notFound", id)));
    }

    //DELETE ONE BY ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)

    public Mono<Void> delete(@PathVariable String id) {
        return escolaService.deleteById(id);
    }

}
