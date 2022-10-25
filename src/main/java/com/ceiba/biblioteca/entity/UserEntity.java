package com.ceiba.biblioteca.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Data
@Table(name="USUARIO")
public class UserEntity {

    @Id
    @Column(name = "IDENTIFICACION_USUARIO", length = 10)
    String identificacionUsuario;

    @Column(name = "TIPO_USUARIO", nullable = false)
    int tipoUsuario;

}
