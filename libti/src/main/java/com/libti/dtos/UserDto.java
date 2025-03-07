package com.libti.dtos;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.libti.models.UserModel;

public class UserDto {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private String profilePicture;

    public UserDto(UserModel userModel) {
       BeanUtils.copyProperties(userModel, this);
    }

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
