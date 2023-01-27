package com.example.demo.resources.impl;

import com.example.demo.domain.User;
import com.example.demo.resources.UserResource;
import com.example.demo.services.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/users")
@RequiredArgsConstructor
public class UserResourceImpl implements UserResource {

    private final UserService userService;

    @Override
    public ResponseEntity<User> findById(Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }
}
