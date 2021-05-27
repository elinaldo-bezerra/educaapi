package com.educacao.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.educacao.api.model.Aluno;
import com.educacao.api.service.AlunoService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author eli
 */
@SpringBootTest
public class AlunoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AlunoService service;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Aluno alunox;
    private Aluno alunoy;

    private String matricula_x;
    private String matricula_y;

    @Test
    void contextLoads() {
        Assert.assertTrue(true);
    }

    @Before
    public void setup() {
        alunox = new Aluno();
        alunox.setId("1");
        alunox.setName("eli");
        alunox.setMatricula(matricula_x);

        alunoy = new Aluno();
        alunoy.setId("2");
        alunoy.setName("ana");
        alunoy.setMatricula(matricula_y);
    }

    @Test
    public void givenAllAlunosReturnJsonArray() throws Exception {
        given(service.findAll()).willReturn(Arrays.asList(alunox));

        mvc.perform(get("/alunos/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alunox.getName())));
    }
    
//    @Test
//    public void givenAlunoOrderNameReturnJsonArray() throws Exception {
//        given(service.findAllOrderName()).willReturn(Arrays.asList(alunoy, alunox));
//
//        mvc.perform(get("/aluno/orderByname/")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].name", is(alunoy.getName())));
//    }

    @Test
    public void saveAlunoReturnStatusOk() throws Exception {
        given(service.saveOrUpdateAluno(any(Aluno.class))).willReturn(alunoy);

        String jsonString = objectMapper.writeValueAsString(alunoy);

        mvc.perform(post("/aluno/save/")
                .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAlunoByMatriculaReturnStatusOk() throws Exception {
        given(service.findByMatricula(matricula_x)).willReturn(alunox);
        Mockito.doNothing().when(service).deleteAlunoById(matricula_x);

        mvc.perform(delete("/aluno/delete/{matricula}", matricula_x)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
