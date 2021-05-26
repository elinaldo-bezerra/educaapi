package com.educacao.api.service;

import com.educacao.api.model.Student;
import com.educacao.api.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author eli
 */

public class StudentServiceTest {

    @TestConfiguration
    static class StudentServiceImplTestContextConfiguration {
        @Bean
        public StudentService studentService() {
            return new StudentServiceImpl();
        }
    }

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    private Student student1;
    private Student student2;

    private final Long student1Number = 23L;
    private final Long student2Number = 91L;
    private final String student1Email = "eli@com.br";
    private final String student2Email = "ana@com.br";
    private final List<Student> students = new ArrayList<>();

    @Before
    public void setup() {
        student1 = new Student();
        student1.setId("aBc123");
        student1.setName("Elinaldo");
        student1.setEmail(student1Email);
        student1.setStudentNumber(student1Number);
        student1.setCourseList(Arrays.asList("Math", "Science"));
        student1.setGpa(3.37f);

        student2 = new Student();
        student2.setId("dEf345");
        student2.setName("Ana");
        student2.setEmail(student2Email);
        student2.setStudentNumber(student2Number);
        student2.setCourseList(Arrays.asList("Turkish", "German"));
        student2.setGpa(3.58f);

        students.add(student1);
        students.add(student2);

        Mockito.when(studentRepository.findAll()).thenReturn(students);

        Mockito.when(studentRepository.findByStudentNumber(student1Number.toString()))
                .thenReturn(student1);

        Mockito.when(studentRepository.findByEmail(student2Email))
                .thenReturn(student2);

        Mockito.when(studentRepository.findAllByOrderByGpaDesc())
                .thenReturn(students.stream().sorted(
                        Comparator.comparing(Student::getGpa).reversed()).collect(Collectors.toList()));

        Mockito.when(studentRepository.save(student1)).thenReturn(student1);
    }

    @Test
    public void testFindAll_thenStudentListShouldBeReturned() {
        List<Student> foundStudents = studentService.findAll();

        assertNotNull(foundStudents);
        assertEquals(2, foundStudents.size());
    }

    @Test
    public void testFindByStudentNumber23_thenRagcrixShouldBeReturned() {
        Student found = studentService.findByStudentNumber(student1Number.toString());

        assertNotNull(found);
        assertEquals(student1.getName(), found.getName());
        assertEquals(student1.getId(), found.getId());
    }

    @Test
    public void testFindByEmail_thenYigitShouldBeReturned() {
        Student found = studentService.findByEmail(student2Email);

        assertNotNull(found);
        assertEquals(student2.getName(), found.getName());
        assertEquals(student2.getId(), found.getId());
    }

    @Test
    public void testFindAllByOrderByGpaDesc_thenStudentsShouldBeReturned_byGPADesc() {
        List<Student> foundStudents = studentService.findAllByOrderByGpaDesc();

        assertNotNull(foundStudents);
        assertEquals(2, foundStudents.size());
        assertEquals(student2.getName(), foundStudents.get(0).getName());
        assertEquals(student2.getId(), foundStudents.get(0).getId());
    }

    @Test
    public void testSaveOrUpdateStudent_thenStudentShouldBeReturned() {
        Student found = studentService.saveOrUpdateStudent(student1);

        assertNotNull(found);
        assertEquals(student1.getName(), found.getName());
        assertEquals(student1.getId(), found.getId());
    }

    @Test
    public void testDeleteStudentById() {
        studentService.deleteStudentById(student1.getId());

        Mockito.verify(studentRepository, Mockito.times(1))
                .deleteById(student1.getId());
    }

}