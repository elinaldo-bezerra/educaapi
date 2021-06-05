package com.educacao.api.controller;

import com.educacao.api.model.Aluno;
import com.educacao.api.service.AlunoService;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux; 
import reactor.core.publisher.Mono;

/**
 * @author eli
 */
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    WebTestClient client;

    @MockBean
    AlunoService alunoService;

    @Test
    public void testGetProductByCodeShouldBeOk() {

     //   final Aluno aluno = new Aluno("1", "1111", "ELINALDO", "url da imagem", null);

       // given(alunoService.findByMatricula("1111")).willReturn(Mono.just(aluno));

        client.get().uri("/api/aluno/1111")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.matricula").isEqualTo("1111")
                .jsonPath("$.name").isEqualTo("ELINALDO")
                .jsonPath("$.imagem").isEqualTo("url da imagem")
                .jsonPath("$.turma").isEqualTo(null);
    }

    @Test
    public void testGetInvalidAlunoShouldReturnNotFound() {
        given(alunoService.findByMatricula("000")).willReturn(Mono.empty());

        client.get().uri("/api/aluno/1111").exchange()
                .expectStatus().isNotFound();
    }

    @Test
    public void testPostValidAlunoShouldReturnCreate() {
  //      final Aluno aluno = new Aluno("1", "1111", "ELINALDO", "url da imagem", null);

    //    given(alunoService.save(BDDMockito.any(Aluno.class))).willReturn(Mono.just(aluno));

//        client.post().uri("/create/").body(BodyInserters.fromObject(aluno))
//                .exchange()
//                .expectStatus().isCreated()
//                .expectBody()
//                .jsonPath("$.id").isEqualTo("1")
//                .jsonPath("$.matricula").isEqualTo("1111")
//                .jsonPath("$.name").isEqualTo("ELINALDO")
//                .jsonPath("$.imagem").isEqualTo("url da imagem")
//                .jsonPath("$.turma").isEqualTo(null);
    }

    @Test
    public void testPostInvalidAlunoShouldReturnBadRequest() {
        final Aluno aluno = new Aluno();
        aluno.setMatricula("DADOS INVÁLIDOS");

        client.post().uri("/lista").body(BodyInserters.fromObject(aluno))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    public void testDeleteValidProductShouldReturnAccept() {
        given(alunoService.deleteByMatricula("1111")).willReturn(Mono.empty());

        client.delete().uri("/delete/1111")
                .exchange()
                .expectStatus().isAccepted();
    }

    @Test
    public void testGetAllProductShouldBeOk() {
//        final Aluno aluno1 = new Aluno("1", "1111", "ELINALDO", "url da imagem de elinaldo", null);
//        final Aluno aluno2 = new Aluno("1", "2222", "ELIANA", "url da imagem de eliana", null);
//
//        given(alunoService.findAll()).willReturn(Flux.just(aluno1, aluno2));

        client.get().uri("/lista")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_STREAM_JSON)
                .expectBodyList(Aluno.class);
    }

}
