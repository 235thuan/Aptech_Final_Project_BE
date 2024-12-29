package com.example.aptech_final_project_be.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ThanhToanException extends RuntimeException {
    public ThanhToanException(String message, Throwable cause) {
        super(message, cause);
    }
}
