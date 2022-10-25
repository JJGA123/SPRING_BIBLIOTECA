package com.ceiba.biblioteca.common.exception;

import com.ceiba.biblioteca.model.ExceptionResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalHandler {

    /**
     * notLend method to receive the exception type
     * @param ex object that contain the exception type
     * @return The response object with information details
     */
    @ExceptionHandler(NotLoan.class)
    public ResponseEntity<ExceptionResponseDto> notLoan(NotLoan ex) {
        ExceptionResponseDto response = ExceptionResponseDto.builder().mensaje("El usuario con identificación " + ex.getMessage() + " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo").build();
        return ResponseEntity.badRequest().body(response);
    }

    /**
     * userTypeNotValid method to receive the exception type
     * @return The response object with information details
     */
    @ExceptionHandler(UserTypeNotValid.class)
    public ResponseEntity<ExceptionResponseDto> userTypeNotValid() {
        ExceptionResponseDto response = ExceptionResponseDto.builder().mensaje("Tipo de usuario no permitido en la biblioteca").build();
        return ResponseEntity.badRequest().body(response);
    }

}