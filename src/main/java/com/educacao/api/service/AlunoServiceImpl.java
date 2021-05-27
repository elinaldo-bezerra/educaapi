package com.educacao.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacao.api.model.Aluno;

import java.util.List;
import com.educacao.api.repository.AlunoRepository;

/**
 * @author eli
 */
@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno findByMatricula(String matricula) {
		return alunoRepository.findByMatricula(matricula);
	}
  
	@Override
	public List<Aluno> findAllOrderName() {
		return alunoRepository.findAllOrderName();
	}

	@Override
	public Aluno saveOrUpdateAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public void deleteStudentById(String id) {
		alunoRepository.deleteById(id);
	}
}