package com.libti.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.libti.dtos.UserDto;
import com.libti.services.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public ResponseEntity<String> putUser(@RequestBody UserDto user) {
        
        try{
            userService.update(user);
            return ResponseEntity.ok("User alterado com sucesso!");
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Erro ao alterar o usuário!");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<UserDto> getUser() {
        UserDto user = userService.getUser();
        return ResponseEntity.ok(user);
    }
    
}
