package com.educacao.api.service;

import java.util.List;

import com.educacao.api.model.Aluno;

/**
 * @author eli
 */
public interface AlunoService {

	List<Aluno> findAll();

	Aluno findByMatricula(String aluno);
 
	List<Aluno> findAllOrderName();

	Aluno saveOrUpdateAluno(Aluno aluno);

	void deleteStudentById(String id);
}