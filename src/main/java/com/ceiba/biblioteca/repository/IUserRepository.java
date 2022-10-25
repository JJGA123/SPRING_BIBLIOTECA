package com.ceiba.biblioteca.repository;

import com.ceiba.biblioteca.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByIdentificacionUsuario(String userIdentity);

}
