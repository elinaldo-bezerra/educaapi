package com.educacao.api.exceptions;

/**
 *
 * @author el1
 */
public class ExceptionsNotFoundException extends RuntimeException {

    public ExceptionsNotFoundException(final String strdocument, String message) {
//        super(String.format("aluno[%s].notFound", message));
        super(String.format(strdocument, message));
    }
}
