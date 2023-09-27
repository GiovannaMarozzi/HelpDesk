package com.help.helpDesk.resources.exceptions;

import com.help.helpDesk.services.exceptions.DataIntegrityViolationException;
import com.help.helpDesk.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<SntandardError> objectNotFoundException(ObjectNotFoundException ex,
                                                                  HttpServletRequest request){

        SntandardError error = new SntandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not Found", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<SntandardError> dataIntegrityViolationException(DataIntegrityViolationException ex,
                                                                  HttpServletRequest request){

        SntandardError error = new SntandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Violação de dados",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

}
