package com.ada.order.service;

import com.ada.order.controller.exception.PasswordValidationError;
import com.ada.order.controller.dto.user.UserRequest;
import com.ada.order.controller.dto.user.UserResponse;
import com.ada.order.model.User;
import com.ada.order.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Page<UserResponse> getUser(int page, int size, String direction){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), "nome");
        Page<User> users = userRepository.findAllActiveUsers(pageRequest);
        return UserConvert.toResponsPage(users);
    }

    public UserResponse saveUser(UserRequest userDTO) throws PasswordValidationError {
      User user = UserConvert.toEntity(userDTO);
      user.setActive(true);
      String encodePassword = passwordEncoder.encode(user.getSenha());
      user.setSenha(encodePassword);
      if(!Validator.passwordValidate(user.getSenha())) throw new PasswordValidationError("senha deve seguir padrao");
      User UserEntity = userRepository.save(user);
      return UserConvert.toResponse(UserEntity);
    }

    public UserResponse getUserById(Integer id){
        Optional<User> userResponse = userRepository.findById(id);
        if (userResponse.isPresent()) {
            return UserConvert.toResponse(userResponse.get());
        }else{
            throw new RuntimeException("nao encontrado");
        }
    }

    public UserResponse getUserByCpf (String cpf){
        User user = (User) userRepository.findByCpf(cpf);
        return UserConvert.toResponse(user);
    }

    public List<UserResponse> getAllByName (String nome){
        return UserConvert.toResponseList(userRepository.findAllByName(nome));
    }


    public void deleteUserById(Integer id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente nao encontrado"));
        user.setActive(false);
        userRepository.save(user);
    }


    public UserResponse updateUser(Integer id, UserRequest userRequest){
        User user = UserConvert.toEntity(userRequest);
        user.setId(id);
        return UserConvert.toResponse(userRepository.save(user));
    }
}
