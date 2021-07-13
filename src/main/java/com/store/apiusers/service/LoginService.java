package com.store.apiusers.service;

import com.store.apiusers.dto.UserLoginDto;
import com.store.apiusers.exceptions.CryptoStoreException;
import com.store.apiusers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserService userService;

    @Autowired
    public LoginService(UserService userService) {
        this.userService = userService;
    }

    public User doLogin(UserLoginDto userLoginDto) {
        User user = userService.getUserById(userLoginDto.getUserId());

        if(!user.getPassword().equals(userLoginDto.getPassword())) {
            throw new CryptoStoreException(HttpStatus.BAD_REQUEST, "Senha inválida");
        }
        return user;
    }

}
