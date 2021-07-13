package com.store.apiusers.repository;

import com.store.apiusers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
