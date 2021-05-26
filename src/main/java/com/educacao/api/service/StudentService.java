package com.educacao.api.service;

import java.util.List;

import com.educacao.api.model.Student;

/**
 * @author eli
 */
public interface StudentService {

	List<Student> findAll();

	Student findByStudentNumber(String studentNumber);

	Student findByEmail(String email);

	List<Student> findAllByOrderByGpaDesc();

	Student saveOrUpdateStudent(Student student);

	void deleteStudentById(String studentNumber);

}