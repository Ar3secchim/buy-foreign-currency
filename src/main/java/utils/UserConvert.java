package utils;


import dto.UserResponse;
import dto.UserRequest;
import model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    public static User toEntity(UserRequest userDTO) {
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setCpf(userDTO.getCpf());
        user.setSenha(userDTO.getSenha());
        user.setActive(true);
        return user;
    }

    public static UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setNome(user.getNome());
        userResponse.setCpf(user.getCpf());
        return userResponse;
    }


    public static List<UserResponse> toResponseList(List<User> users){
        List<UserResponse> userResponses =  new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = UserConvert.toResponse(user);
            userResponses.add(userResponse);
        }
            return userResponses;

        }

        public static Page<UserResponse> toResponsPage(Page<User> users){
            List<UserResponse> userResponses = new ArrayList<>();
            for (User user :  users){
                UserResponse userResponse = UserConvert.toResponse(user);
                userResponses.add(userResponse);
            }
             return new PageImpl<>(userResponses);
    }

}
