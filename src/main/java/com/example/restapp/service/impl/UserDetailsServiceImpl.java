package com.example.restapp.service.impl;

import com.example.restapp.domain.User;
import com.example.restapp.repo.UserDetailsRepo;
import com.example.restapp.service.UserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepo userDetailsRepo;

    @Override
    public Optional<User> findById(String id) {
        return userDetailsRepo.findById(id);
    }

    @Override
    public User save(User user) {
        return userDetailsRepo.save(user);
    }
}
