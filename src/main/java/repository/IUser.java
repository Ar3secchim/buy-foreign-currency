package repository;

import model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.security.core.userdetails.UserDetails;

import java.awt.print.Pageable;
import java.util.List;

public interface IUser extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User>{


    @Query(value = "SELECT * FROM USER WHERE ACTIVE = TRUE",nativeQuery = true)
    Page<User> findAllActiveUsers(Pageable pageable);


    List<User> findAllByName (String nome);

    UserDetails findByCpf (String cpf);




}
