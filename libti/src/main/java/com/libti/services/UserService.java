package com.libti.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libti.repositories.UserRepository;

import com.libti.dtos.UserDto;
import com.libti.models.UserModel;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
	private PasswordEncoder passwordEncoder;

    public List<UserDto> listUsers(){
        List<UserModel> users = userRepository.findAll();
        return users.stream().map(UserDto::new).toList();
    }

    public void insert(UserDto user){
        UserModel userModel = new UserModel();
        userModel.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userModel);
    }
}
