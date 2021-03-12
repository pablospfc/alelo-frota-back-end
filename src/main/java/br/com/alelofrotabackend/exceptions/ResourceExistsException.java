package br.com.alelofrotabackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CREATED)
public class ResourceExistsException extends Exception {
    public ResourceExistsException(String message) {
        super(message);
    }
}
