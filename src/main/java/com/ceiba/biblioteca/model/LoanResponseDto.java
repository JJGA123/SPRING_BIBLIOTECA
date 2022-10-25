package com.ceiba.biblioteca.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class LoanResponseDto {

    int id;
    LocalDate fechaMaximaDevolucion;
}
