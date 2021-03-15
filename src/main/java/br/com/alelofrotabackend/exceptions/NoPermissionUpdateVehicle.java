package br.com.alelofrotabackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NoPermissionUpdateVehicle extends Exception {

    public NoPermissionUpdateVehicle(String message) {
        super(message);
    }
}
