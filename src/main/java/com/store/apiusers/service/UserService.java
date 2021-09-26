package com.store.apiusers.service;

import com.store.apiusers.exceptions.CryptoStoreException;
import com.store.apiusers.model.User;
import com.store.apiusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        Optional<User> userOptional = repository.findById(user.getId());
        if(userOptional.isPresent()) {
            throw new CryptoStoreException(BAD_REQUEST, "Usuário já existente");
        }
        return this.repository.save(user);
    }

    public User getUserById(String id) {
        Optional<User> userOptional = this.repository.findById(id);
        return userOptional.orElseThrow(() -> new CryptoStoreException(HttpStatus.NO_CONTENT, "Usuário não encontrado"));
    }
}
