package service;

import dto.UserRequest;
import dto.UserResponse;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import repository.IUser;
import utils.UserConvert;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserService {

    @Autowired
    IUser userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Page<UserResponse> getUser(int page, int size, String direction){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), "name");
        Page<User> users = userRepository.findAllActiveUsers(pageRequest);
        return UserConvert.toResponsPage(users);
    }

    public UserResponse saveUser(UserRequest userDTO) throws PasswordValidationError{
      User user = UserConvert.toEntity(userDTO);
      user.setActive(true);
      String encodePassword =  passwordEncoder.encode(user.getPassword());
      user.setPassword(encodePassword);
      if(!Validator.passwordValidate(user.getPassword())) throw new PasswordValidationError("senha deve seguir padrao");
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
                .orElseThrow() -> new NoSuchElementException("Cliente nao encontrado");
        user.setActive(false);
        userRepository.save(user);
    }


    public UserResponse updateUser(Integer id, UserRequest userRequest){
        User user = UserConvert.toEntity(userRequest);
        user.setId(id);
        return UserConvert.toResponse(userRepository.save(user));
    }






}
