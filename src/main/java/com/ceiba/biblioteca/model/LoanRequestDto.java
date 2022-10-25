package com.ceiba.biblioteca.model;

import lombok.Getter;

@Getter
public class LoanRequestDto {

    String isbn;
    String identificacionUsuario;
    int tipoUsuario;

}
