package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.model.DetailLoanResponseDto;
import com.ceiba.biblioteca.model.LoanRequestDto;
import com.ceiba.biblioteca.model.LoanResponseDto;

public interface ILoanService {

    LoanResponseDto loan(LoanRequestDto requestDto);
    DetailLoanResponseDto loanDetail(int id);

}
