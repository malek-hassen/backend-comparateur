package com.example.comparateur.user.service;


import com.example.comparateur.user.dto.UserDto;
import com.example.comparateur.user.entity.AppUser;
import com.example.comparateur.user.mapper.UserMapper;
import com.example.comparateur.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserMapper userMapper;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<AppUser> getAllUsers() {

        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
    public AppUser getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public AppUser saveUser(UserDto user) {

        return userRepository.save( userMapper.toEntity(user));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
