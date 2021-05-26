package com.educacao.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.educacao.api.model.Student;
import com.educacao.api.service.StudentService;

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
public class StudentRestControllerTest {

	
	
    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Student ragcrix;
    private Student yigit;

    private final Long ragcrixStudentNumber = 23L;
    private final Long yigitStudentNumber = 91L;
    
    @Test
	void contextLoads() {
		 Assert.assertTrue(true);
	}

    @Before
    public void setup() {
        ragcrix = new Student();
        ragcrix.setId("aBc123");
      //  ragcrix.setName("ragcrix");
        ragcrix.setEmail("ragcrix@rg.com");
        ragcrix.setStudentNumber(ragcrixStudentNumber);
        ragcrix.setCourseList(Arrays.asList("Math", "Science"));
        ragcrix.setGpa(3.37f);

        yigit = new Student();
        yigit.setId("dEf345");
        yigit.setName("yigit");
        yigit.setEmail("yigit@ygt.com");
        yigit.setStudentNumber(yigitStudentNumber);
        yigit.setCourseList(Arrays.asList("Turkish", "German"));
        yigit.setGpa(3.58f);
    }

    @Test
    public void givenStudents_whenGetAllStudents_thenReturnJsonArray() throws Exception {
        given(studentService.findAll()).willReturn(Arrays.asList(ragcrix));

        mvc.perform(get("/students/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(ragcrix.getName())));
    }

    @Test
    public void givenStudent_whenFindByStudentNumber_thenReturnJsonArray() throws Exception {
        given(studentService.findByStudentNumber(ragcrixStudentNumber.toString())).willReturn(ragcrix);

        mvc.perform(get("/students/byStudentNumber/{studentNumber}", ragcrixStudentNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(ragcrix.getName())));
    }

    @Test
    public void givenStudent_whenFindAllByOrderByGpaDesc_thenReturnJsonArray() throws Exception {
        given(studentService.findAllByOrderByGpaDesc()).willReturn(Arrays.asList(yigit, ragcrix));

        mvc.perform(get("/students/orderByGpa/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(yigit.getName())));
    }

    @Test
    public void saveStudent_itShouldReturnStatusOk() throws Exception {
        given(studentService.saveOrUpdateStudent(any(Student.class))).willReturn(yigit);

        String jsonString = objectMapper.writeValueAsString(yigit);

        mvc.perform(post("/students/save/")
                .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteStudentByStudentNumber_itShouldReturnStatusOk() throws Exception {
        given(studentService.findByStudentNumber(ragcrixStudentNumber.toString())).willReturn(ragcrix);
        Mockito.doNothing().when(studentService).deleteStudentById(any(String.class));

        mvc.perform(delete("/students/delete/{studentNumber}", ragcrixStudentNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}