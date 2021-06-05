package com.educacao.api.controller;

import com.educacao.api.model.Aluno;
import com.educacao.api.service.AlunoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

/**
 * @author eli
 */
@RunWith(SpringRunner.class)
@WebFluxTest(AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    WebTestClient webClient;

    @MockBean
    AlunoService alunoService;

    @Test
    public void testGetAllProductShouldBeOk() {
        final Aluno aluno1 = new Aluno("1", "1111", "ELINALDO", "url da imagem de elinaldo", "039.690.554-40", null);
        final Aluno aluno2 = new Aluno("2", "2222", "NALDO", "url da imagem de NALDO", "039.690.554-40",null);
        final Aluno aluno3 = new Aluno("3", "3333", "ELI", "url da imagem de ELI", "039.690.554-40",null);
        final Aluno aluno4 = new Aluno("4", "4444", "ANA", "url da imagem de ANA","039.690.554-41", null);

        given(alunoService.findAll()).willReturn(Flux.just(aluno1, aluno2, aluno3, aluno4));

        webClient.get().uri("/api/v1/aluno/")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_STREAM_JSON)
                .expectBodyList(Aluno.class);
        System.out.println("Tudo certo nessa pega");
    }

//    @Test
//    void testCreateAluno() {
//
//        alunoMap.put(new Aluno("100", "1000", "teste", "imagem teste", null));
//
//        Mockito.when(alunoService.save(aluno)).thenReturn(Mono.just(aluno));
//
//        webClient.post()
//                .uri("/create")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromObject(aluno))
//                .exchange()
//                .expectStatus().isCreated();
//
//        Mockito.verify(alunoService, times(1)).save(aluno);
//    }
//
//    @Test
//    public void testGetInvalidAlunoShouldReturnNotFound() {
//        given(alunoService.findByMatricula("000")).willReturn(Mono.empty());
//
//        webClient.get().uri("/api/aluno/1111").exchange()
//                .expectStatus().isNotFound();
//    }
//
//    @Test
//    public void testPostValidAlunoShouldReturnCreate() {
//        //      final Aluno aluno = new Aluno("1", "1111", "ELINALDO", "url da imagem", null);
//
//        //    given(alunoService.save(BDDMockito.any(Aluno.class))).willReturn(Mono.just(aluno));
////        client.post().uri("/create/").body(BodyInserters.fromObject(aluno))
////                .exchange()
////                .expectStatus().isCreated()
////                .expectBody()
////                .jsonPath("$.id").isEqualTo("1")
////                .jsonPath("$.matricula").isEqualTo("1111")
////                .jsonPath("$.name").isEqualTo("ELINALDO")
////                .jsonPath("$.imagem").isEqualTo("url da imagem")
////                .jsonPath("$.turma").isEqualTo(null);
//    }
//
//    @Test
//    public void testPostInvalidAlunoShouldReturnBadRequest() {
//        final Aluno aluno = new Aluno();
//        aluno.setMatricula("DADOS INVÁLIDOS");
//
//        webClient.post().uri("/lista").body(BodyInserters.fromObject(aluno))
//                .exchange()
//                .expectStatus().isBadRequest();
//    }
//
//    @Test
//    public void testDeleteValidProductShouldReturnAccept() {
//        given(alunoService.deleteByMatricula("1111")).willReturn(Mono.empty());
//
//        webClient.delete().uri("/delete/1111")
//                .exchange()
//                .expectStatus().isAccepted();
//    }
//
//    
}
