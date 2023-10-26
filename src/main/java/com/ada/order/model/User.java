package com.ada.order.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
@Where(clause = "active is true")


public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "nome", nullable = false)
    private String nome;

    @Column (name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column (name = "dataDeNascimento", nullable = false)
    private Double dataDeNascimento;

    @Column (name = "estadoCivil", nullable = false)
    private String estadoCivil;

    @Column (name = "sexo", nullable = false)
    private String sexo;

    @Column (name = "senha", nullable = false)
    private String senha;

    private Boolean active;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}





