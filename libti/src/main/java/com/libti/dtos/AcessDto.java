package com.libti.dtos;

public class AcessDto {
    private String token;

    public AcessDto(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
