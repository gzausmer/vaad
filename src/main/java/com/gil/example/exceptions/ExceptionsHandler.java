package com.gil.example.exceptions;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(Exception.class)
    public void handleConflict(HttpServletResponse response, ApplicationException e) {
        e.printStackTrace();
        String errorMessage = e.getMessage();
        response.setStatus(500);
        response.setHeader("errorMessage", errorMessage);
    }
}
