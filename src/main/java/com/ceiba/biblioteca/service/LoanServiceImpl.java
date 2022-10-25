package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.common.Mapper;
import com.ceiba.biblioteca.common.exception.NotLoan;
import com.ceiba.biblioteca.common.exception.UserTypeNotValid;
import com.ceiba.biblioteca.entity.BookEntity;
import com.ceiba.biblioteca.entity.LoanEntity;
import com.ceiba.biblioteca.entity.UserEntity;
import com.ceiba.biblioteca.model.DetailLoanResponseDto;
import com.ceiba.biblioteca.model.LoanRequestDto;
import com.ceiba.biblioteca.model.LoanResponseDto;
import com.ceiba.biblioteca.repository.IBookRepository;
import com.ceiba.biblioteca.repository.ILoanRepository;
import com.ceiba.biblioteca.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoanServiceImpl implements ILoanService {

    public static final int AFFILIATED_USER = 1;
    public static final int EMPLOYEE_USER = 2;
    public static final int GUEST_USER = 3;

    private final ILoanRepository loanRepository;
    private final IUserRepository userRepository;
    private final IBookRepository bookRepository;

    public LoanServiceImpl(ILoanRepository loanRepository, IUserRepository userRepository, IBookRepository bookRepository){
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    /**
     * This method allows to validate the loan process
     * @param requestDto object with information for validations
     * @return LoanResponseDto with the response data
     */
    public LoanResponseDto loan(LoanRequestDto requestDto) {
        UserEntity user = userRepository.findByIdentificacionUsuario(requestDto.getIdentificacionUsuario());
        BookEntity book = bookRepository.findByIsbn(requestDto.getIsbn());
        if(requestDto.getTipoUsuario()!=AFFILIATED_USER && requestDto.getTipoUsuario()!=EMPLOYEE_USER && requestDto.getTipoUsuario()!=GUEST_USER){
            throw new UserTypeNotValid();
        }
        return loanValidations(user,book,requestDto);
    }

    /**
     * This method allows to validate the loan process and save loan data
     * @param user object with user information for validations
     * @param book object with book information for validations
     * @param requestDto object with book information for validations
     * @return LoanResponseDto with the response data
     */
    @Transactional
    private LoanResponseDto loanValidations(UserEntity user, BookEntity book,LoanRequestDto requestDto){
        LoanEntity loan = new LoanEntity();
        switch (requestDto.getTipoUsuario()) {
            case AFFILIATED_USER:
                loan = Mapper.toLoanEntity(user,book,10);
                break;
            case EMPLOYEE_USER:
                loan = Mapper.toLoanEntity(user,book,8);
                break;
            case GUEST_USER:
                List<LoanEntity> loans = loanRepository.findByIdentificacionUsuario(user);
                if(loans.size()>0){
                    throw new NotLoan(user.getIdentificacionUsuario());
                }
                loan = Mapper.toLoanEntity(user,book,7);
                break;
        }
        loanRepository.save(loan);
        return Mapper.toLoanResponseDto(loan);
    }

    /**
     * This method allows get the loan detail
     * @param id identifier by get loan detail
     * @return a DetailLoanResponseDto with the data found
     */
    public DetailLoanResponseDto loanDetail(int id) {
        LoanEntity prestamo = loanRepository.findById(id).orElse(null);
        return Mapper.toLoanDetailResponseDto(prestamo);
    }

}