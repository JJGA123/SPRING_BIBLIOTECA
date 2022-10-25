package com.ceiba.biblioteca.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name="LIBRO")
public class BookEntity {

    @Id
    @Column(name = "ISBN", length = 10)
    String isbn;

}
