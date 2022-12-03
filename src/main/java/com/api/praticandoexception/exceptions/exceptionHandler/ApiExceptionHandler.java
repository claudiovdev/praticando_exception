package com.api.praticandoexception.exceptions.exceptionHandler;

import com.api.praticandoexception.exceptions.EntidadeNaoEncontradaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    // Metodo criado para realizar um construtor da mensagem que irá aparecer quando estourar uma exception
    private Problema.ProblemaBuilder criarConstrutorDeProblema(HttpStatus status, TipoDeProblema tipoDeProblema, String detalhes) {
        return Problema.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .tipo(tipoDeProblema.getUri())
                .detalhe(detalhes);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (body == null) {
            body = Problema.builder()
                    .timestamp(LocalDateTime.now())
                    .titulo(status.getReasonPhrase())
                    .status(status.value()).build();
        } else if (body instanceof String) {
            body = Problema.builder()
                    .timestamp(LocalDateTime.now())
                    .titulo((String) body)
                    .status(status.value()).build();
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    private ResponseEntity<Object> handleEntidadeNaoEncontradaException( EntidadeNaoEncontradaException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        TipoDeProblema tipoDeProblema = TipoDeProblema.RECURSO_NAO_ENCONTRADO;
        String detalhe = ex.getMessage();
        Problema problema = criarConstrutorDeProblema(status, tipoDeProblema, detalhe).build();
        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }

}
