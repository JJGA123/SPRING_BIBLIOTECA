package com.ceiba.biblioteca.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="PRESTAMO")
public class LoanEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "ISBN", nullable = false)
    BookEntity isbn;

    @ManyToOne
    @JoinColumn(name = "IDENTIFICACION_USUARIO", nullable = false)
    UserEntity identificacionUsuario;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    LocalDate fechaRegistro;

    @Column(name = "FECHA_DEVOLUCION", nullable = false)
    LocalDate fechaDevolucion;

}
