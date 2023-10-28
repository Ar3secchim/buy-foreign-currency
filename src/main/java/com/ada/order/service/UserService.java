package com.ada.order.service;

import com.ada.order.controller.exception.PasswordValidationError;
import com.ada.order.controller.dto.user.UserRequest;
import com.ada.order.controller.dto.user.UserResponse;
import com.ada.order.controller.exception.ValidationError;
import com.ada.order.model.User;
import com.ada.order.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ada.order.repository.IUserRepository;
import com.ada.order.utils.UserConvert;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserResponse> getUser(){
        return UserConvert.toResponseList(userRepository.findAll());
    }

    public UserResponse saveUser(User user) throws PasswordValidationError {
      String encodePassword = passwordEncoder.encode(user.getSenha());

      user.setSenha(encodePassword);

      if(!Validator.passwordValidate(user.getSenha())) throw new PasswordValidationError("senha deve seguir padrao");

      return UserConvert.toResponse(userRepository.save(user));
    }

    public UserResponse getUserById(Integer id){
        Optional<User> userResponse = userRepository.findById(id);

        if (userResponse.isPresent()) {
            return UserConvert.toResponse(userResponse.get());
        }else{
            throw new RuntimeException("nao encontrado");
        }
    }

    public UserResponse getUserByCpf(String cpf){
        User user = (User) userRepository.findByCpf(cpf);
        return UserConvert.toResponse(user);
    }

    public List<UserResponse> getAllByName (String nome){
        return UserConvert.toResponseList(userRepository.findAllByName(nome));
    }


    public void deleteUserById(Integer id){
        if(id != null){
            userRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("Cliente nao encontrado");
        }
    }
}
