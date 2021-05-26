package com.educacao.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educacao.api.model.Student;

import java.util.List;

/**
 * @author eli 
 */

// No need implementation, just one interface, and you have CRUD, thanks Spring Data!
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByStudentNumber(String studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpaDesc();

}