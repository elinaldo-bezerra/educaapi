package com.educacao.api.controller;


import com.educacao.api.model.Aluno;
import com.educacao.api.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author eli
 */
@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping(value = "/listar")
    public List<Aluno> getAllAlunos() {
        return alunoService.findAll();
    }

    @GetMapping(value = "/{matricula}")
    public Aluno getAlunoMatricula(@PathVariable("matricula") String matricula) {
        return alunoService.findByMatricula(matricula);
    }
 
//    @GetMapping(value = "/orderByname")
//    public List<Aluno> findAllOrderName() {
//        return alunoService.findAllOrderName();
//    }

    @PostMapping(value = "/save")
    public ResponseEntity<Aluno> saveOrUpdateAluno(@RequestBody Aluno aluno) {
        alunoService.saveOrUpdateAluno(aluno);
        return new ResponseEntity("Aluno adicionado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{matricula}")
    public ResponseEntity<Aluno> deleteAlunoByMatricula(@PathVariable String matricula) {   
        alunoService.deleteAlunoById(alunoService.findByMatricula(matricula).getId());
        return new ResponseEntity("Aluno removido com sucesso!", HttpStatus.OK);
    }
}