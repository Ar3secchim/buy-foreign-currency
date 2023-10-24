package com.ada.order.Controller.dto;


import com.ada.order.Controller.dto.exception.PasswordValidationError;
import com.ada.order.Controller.dto.user.UserRequest;
import com.ada.order.Controller.dto.user.UserResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ada.order.service.UserService;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping
    public ResponseEntity<Page<UserResponse>> getUser(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0"
            ) int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10"
            ) int size,
            @RequestParam(
                    value = "direction",
                    required = false,
                    defaultValue = "ASC"
            ) String direction
    ) {
        return ResponseEntity.ok(userService.getUser(page, size, direction));
    }

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(
            @Valid @RequestBody UserRequest userDTO
    ) throws PasswordValidationError {
        UserResponse user = userService.saveUser(userDTO);
        return ResponseEntity.created(URI.create("/user/" + user.getId())).body(user);
    }

    @GetMapping("/{id})")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UserResponse> getUserByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(userService.getUserByCpf(cpf));
    }

    @GetMapping("/nome{nome}")
    public ResponseEntity<UserResponse> getAllCustomerByName(@PathVariable String nome, @PathVariable Integer id) {
        return ResponseEntity.ok((UserResponse) userService.getAllByName(nome));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Integer id, @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.updateUser(id, userRequest));
    }

}