package com.educacao.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacao.api.model.Student;
import com.educacao.api.repository.StudentRepository;

import java.util.List;

/**
 * @author eli
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findByStudentNumber(String studentNumber) {
		return studentRepository.findByStudentNumber(studentNumber);
	}

	@Override
	public Student findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Override
	public List<Student> findAllByOrderByGpaDesc() {
		return studentRepository.findAllByOrderByGpaDesc();
	}

	@Override
	public Student saveOrUpdateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(String studentNumber) {
		studentRepository.deleteById(studentNumber);
	}
}