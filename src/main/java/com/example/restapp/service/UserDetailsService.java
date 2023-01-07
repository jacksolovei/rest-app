package com.example.restapp.service;

import com.example.restapp.domain.User;

import java.util.Optional;

public interface UserDetailsService {
    Optional<User> findById(String id);
    User save(User user);
}
