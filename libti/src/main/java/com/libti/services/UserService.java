package com.libti.services;

import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libti.repositories.UserRepository;

import com.libti.dtos.UserDto;
import com.libti.models.UserModel;
import com.libti.security.jwt.JwtUtils;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public List<UserDto> listUsers(){
        List<UserModel> users = userRepository.findAll();
        return users.stream().map(UserDto::new).toList();
    }

    public void insert(UserDto user){
        UserModel userModel = new UserModel();
        userModel.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userModel);
    }

    public void update(UserDto user){
        System.out.println("Autenticação no método update: " + SecurityContextHolder.getContext().getAuthentication());
        String token = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        System.out.println("Token recebido: " + token);
        UUID userId = jwtUtils.getIdFromToken(token);

        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(passwordEncoder.encode(user.getPassword()));

        try{
            String sanitizedInput = new String(user.getProfilePicture()).replaceAll("\\s+", "");
            byte[] decodedCover = Base64.getDecoder().decode(sanitizedInput);
            userModel.setProfilePicture(decodedCover);
        } catch (Exception e) {
            e.printStackTrace();
        }

        userRepository.save(userModel);

    }
}
