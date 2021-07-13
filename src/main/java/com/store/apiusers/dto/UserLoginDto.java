package com.store.apiusers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginDto {
    @JsonProperty("id")
    private String userId;

    @JsonProperty("password")
    private String password;

    public UserLoginDto() {
    }

    public UserLoginDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
