package com.libti.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.libti.repositories.UserRepository;

import com.libti.dtos.UserDto;
import com.libti.models.UserModel;
import com.libti.security.jwt.JwtUtils;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public List<UserDto> listUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream().map(UserDto::new).toList();
    }

    public UserDto getUser() {
        String token = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        UUID userId = jwtUtils.getIdFromToken(token);
        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(userModel);
    }

    public void update(UserDto user, MultipartFile profilePicture) {
        System.out.println("Autenticação no método update: " + SecurityContextHolder.getContext().getAuthentication());
        String token = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        System.out.println("Token recebido: " + token);
        UUID userId = jwtUtils.getIdFromToken(token);

        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(passwordEncoder.encode(user.getPassword()));

        if (profilePicture != null && !profilePicture.isEmpty()) {
            try {
                String uploadDir = "./uploads/";
                String fileName = UUID.randomUUID() + "_" + profilePicture.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);

                // Cria o diretório se ele não existir
                Files.createDirectories(filePath.getParent());

                // Salva o arquivo no sistema de arquivos
                Files.write(filePath, profilePicture.getBytes());

                // Atualiza o caminho da imagem no banco
                userModel.setProfilePicture("/uploads/" + fileName);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
            }
        }

        userRepository.save(userModel);

    }

    public boolean isValidBase64(String base64) {
        try {
            Base64.getDecoder().decode(base64);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void register(UserDto user) {
        UserModel userModel = new UserModel(user);
        UserModel userVef = userRepository.findByEmail(user.getEmail()).orElse(userModel);
        if (userVef.getEmail() != userModel.getEmail()) {
            throw new RuntimeException("User already exists");
        } else {
            userModel.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(userModel);
        }

    }
}
