package com.educacao.api.service;

import com.educacao.api.model.Aluno;
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
import com.educacao.api.repository.AlunoRepository;

/**
 * @author eli
 */
public class AlunoServiceTest {

    @TestConfiguration
    static class AlunoServiceImplTestContextConfiguration {

        @Bean
        public AlunoService service() {
            return new AlunoServiceImpl();
        }
    }

    @Autowired
    private AlunoService service;

    @MockBean
    private AlunoRepository alunoRepository;

    private Aluno alunox;
    private Aluno alunoy;

    private final String matricula_x = "1111";
    private final String matricula_y = "2222";

    private final List<Aluno> alunos = new ArrayList<>();

    @Before
    public void setup() {
        alunox = new Aluno();
        alunox.setId("1");
        alunox.setName("Eli");
        alunox.setMatricula(matricula_x);

        alunoy = new Aluno();
        alunoy.setId("2");
        alunoy.setName("Ana");
        alunoy.setMatricula(matricula_y);

        alunos.add(alunox);
        alunos.add(alunoy);

        Mockito.when(alunoRepository.findAll()).thenReturn(alunos);

        Mockito.when(alunoRepository.findByMatricula(matricula_x))
                .thenReturn(alunox);

//
//        Mockito.when(alunoRepository.findAllOrderName())
//                .thenReturn(alunox.stream().sorted(
//                        Comparator.comparing(Aluno::getGpa).reversed()).collect(Collectors.toList()));

        Mockito.when(alunoRepository.save(alunox)).thenReturn(alunox);
    }

    @Test
    public void testFindAll_thenStudentListShouldBeReturned() {
        List<Aluno> foundStudents = service.findAll();

        assertNotNull(foundStudents);
        assertEquals(2, foundStudents.size());
    }

    @Test
    public void testFindByStudentNumber23_thenRagcrixShouldBeReturned() {
        Aluno found = service.findByMatricula(matricula_x);

        assertNotNull(found);
        assertEquals(alunox.getName(), found.getName());
        assertEquals(alunox.getId(), found.getId());
    }

    
    @Test
    public void testFindAllByOrderByGpaDesc_thenStudentsShouldBeReturned_byGPADesc() {
        List<Aluno> foundStudents = service.findAllOrderName();

        assertNotNull(foundStudents);
        assertEquals(2, foundStudents.size());
        assertEquals(alunoy.getName(), foundStudents.get(0).getName());
        assertEquals(alunoy.getId(), foundStudents.get(0).getId());
    }

    @Test
    public void testSaveOrUpdateStudent_thenStudentShouldBeReturned() {
        Aluno found = service.saveOrUpdateAluno(alunox);

        assertNotNull(found);
        assertEquals(alunox.getName(), found.getName());
        assertEquals(alunox.getId(), found.getId());
    }

    @Test
    public void testDeleteStudentById() {
        service.deleteStudentById(alunox.getId());

        Mockito.verify(alunoRepository, Mockito.times(1))
                .deleteById(alunox.getId());
    }

}
