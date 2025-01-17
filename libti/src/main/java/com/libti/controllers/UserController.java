package com.libti.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.libti.dtos.UserDto;
import com.libti.services.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public ResponseEntity<?> putUser(
            @RequestParam("user") String userDtoString,
            @RequestParam(value = "profilePicture", required = false) MultipartFile profilePicture) {

        try {
            // Converter o JSON para o objeto UserDto
            ObjectMapper objectMapper = new ObjectMapper();
            UserDto userDto = objectMapper.readValue(userDtoString, UserDto.class);

            // Chamar o serviço de atualização
            userService.update(userDto, profilePicture);
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar a requisição");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<UserDto> getUser() {
        UserDto user = userService.getUser();
        return ResponseEntity.ok(user);
    }

}
