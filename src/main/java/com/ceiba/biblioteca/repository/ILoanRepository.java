package com.ceiba.biblioteca.repository;

import com.ceiba.biblioteca.entity.LoanEntity;
import com.ceiba.biblioteca.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILoanRepository extends JpaRepository<LoanEntity, Integer> {

    List<LoanEntity> findByIdentificacionUsuario(UserEntity user);

}
