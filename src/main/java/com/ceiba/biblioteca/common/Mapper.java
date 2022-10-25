package com.ceiba.biblioteca.common;

import com.ceiba.biblioteca.entity.BookEntity;
import com.ceiba.biblioteca.entity.LoanEntity;
import com.ceiba.biblioteca.entity.UserEntity;
import com.ceiba.biblioteca.model.DetailLoanResponseDto;
import com.ceiba.biblioteca.model.LoanResponseDto;

public class Mapper {

    /**
     * toLoanEntity change the information
     * @param user object that contains the information to change
     * @param book object that contains the information to change
     * @param maxReturn object that contains the information to change
     * @return Object Entity
     */
    public static LoanEntity toLoanEntity (UserEntity user, BookEntity book, int maxReturn){
        return LoanEntity.builder()
                .isbn(book)
                .identificacionUsuario(user)
                .fechaRegistro(Util.today())
                .fechaDevolucion(Util.addDaysSkippingWeekends(maxReturn)).build();
    }

    /**
     * toLoanEntity change the information
     * @param loan object that contains the information to change
     * @return Object Dto
     */
    public static DetailLoanResponseDto toLoanDetailResponseDto(LoanEntity loan){
        return DetailLoanResponseDto.builder()
                .id(loan.getId())
                .fechaMaximaDevolucion(Util.dateFormat(loan.getFechaDevolucion()))
                .isbn(loan.getIsbn().getIsbn())
                .identificacionUsuario(loan.getIdentificacionUsuario().getIdentificacionUsuario())
                .tipoUsuario(loan.getIdentificacionUsuario().getTipoUsuario()).build();
    }

    /**
     * toLoanEntity change the information
     * @param loan object that contains the information to change
     * @return Object Dto
     */
    public static LoanResponseDto toLoanResponseDto(LoanEntity loan){
        return LoanResponseDto.builder().id(loan.getId()).fechaMaximaDevolucion(loan.getFechaDevolucion()).build();
    }
}
