package com.hneu.api.controller.exception;

import com.hneu.api.dto.ExceptionView;
import com.hneu.api.exception.EntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EntityException.class)
    @ResponseBody
    public ResponseEntity<ExceptionView> proxyRestException(EntityException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(createExceptionView(e, status), status);
    }

    private ExceptionView createExceptionView(Exception e, HttpStatus status) {
        ExceptionView response = new ExceptionView();

        response.setTimestamp(System.currentTimeMillis());
        response.setMessage(e.getMessage());
        response.setStatus(status.value());
        response.setError(status.getReasonPhrase());
        response.setException(e.getClass().toString());

        return response;
    }
}
