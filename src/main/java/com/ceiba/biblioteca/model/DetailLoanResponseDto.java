package com.ceiba.biblioteca.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DetailLoanResponseDto {

    int id;
    String fechaMaximaDevolucion;
    String isbn;
    String identificacionUsuario;
    int tipoUsuario;

}
