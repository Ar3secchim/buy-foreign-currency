package com.ada.order.repository;

import com.ada.order.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User>{

    @Query(value = "SELECT * FROM USER WHERE ACTIVE = TRUE",nativeQuery = true)
    Page<User> findAllActiveUsers(Pageable pageable);

    List<User> findAllByName (String nome);

    User findByCpf (String cpf);
}
