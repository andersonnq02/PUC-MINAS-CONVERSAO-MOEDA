package br.com.currencyconverter.adapter.in.advice;


import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    private static final String MENSAGEM = "mensagem";
    private static final String CODIGO = "codigo";
    private static final String FAILED_DEPENDENCY_CODE = "424";
    private static final String BAD_REQUEST_CODE = "400";
    private static final String NOT_FOUND_CODE = "404";


    @ExceptionHandler(value = {ResourceAccessException.class})
    public ResponseEntity<Object> tratarExcecaoResourceAccessException(final ResourceAccessException ex) {

        Map<String, String> body = new HashMap<>();
        body.put(CODIGO, BAD_REQUEST_CODE);
        body.put(MENSAGEM, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<Object> tratarExcecaoIllegalStateException(final IllegalStateException ex) {

        Map<String, String> body = new HashMap<>();
        body.put(CODIGO, FAILED_DEPENDENCY_CODE);
        body.put(MENSAGEM, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.FAILED_DEPENDENCY);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> tratarExcecaoNotFoundException(final NotFoundException ex) {

        Map<String, String> body = new HashMap<>();
        body.put(CODIGO, NOT_FOUND_CODE);
        body.put(MENSAGEM, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> tratarExcecaoIllegalArgumentException(final IllegalArgumentException ex) {

        Map<String, String> body = new HashMap<>();
        body.put(CODIGO, BAD_REQUEST_CODE);
        body.put(MENSAGEM, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<Object> tratarExcecaoHttpClientErrorException(final HttpClientErrorException ex) {

        Map<String, String> body = new HashMap<>();
        body.put(CODIGO, BAD_REQUEST_CODE);
        body.put(MENSAGEM, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}

