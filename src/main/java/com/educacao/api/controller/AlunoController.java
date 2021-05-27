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
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping(value = "/todos")
    public List<Aluno> getAllStudents() {
        return alunoService.findAll();
    }

    @GetMapping(value = "/matricula/{matricula}")
    public Aluno getStudentByStudentNumber(@PathVariable("studentNumber") String matricula) {
        return alunoService.findByMatricula(matricula);
    }
 
    @GetMapping(value = "/orderByname")
    public List<Aluno> findAllByOrderByGpaDesc() {
        return alunoService.findAllOrderName();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Aluno> saveOrUpdateStudent(@RequestBody Aluno aluno) {
        alunoService.saveOrUpdateAluno(aluno);
        return new ResponseEntity("Aluno adicionado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{matricula}")
    public ResponseEntity<Aluno> deleteStudentByStudentNumber(@PathVariable String matricula) {   
        alunoService.deleteStudentById(alunoService.findByMatricula(matricula).getId());
        return new ResponseEntity("Aluno removido com sucesso!", HttpStatus.OK);
    }
}