package com.example.demo.services.impl;

import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
