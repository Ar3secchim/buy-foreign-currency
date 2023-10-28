package com.ada.order.repository;

import com.ada.order.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer>{

    List<User> findAllByName (String nome);

    UserDetails findByCpf (String cpf);
}
