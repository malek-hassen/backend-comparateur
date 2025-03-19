package com.example.comparateur.user.controller;

import com.example.comparateur.operateur.dto.OperateurDTO;
import com.example.comparateur.user.dto.UserDto;
import com.example.comparateur.user.entity.AppUser;
import com.example.comparateur.user.mapper.UserMapper;
import com.example.comparateur.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {

      private final UserService userService;
      private final UserMapper userMapper;
      public UserController(UserService userService, UserMapper userMapper) {
          this.userService = userService;
          this.userMapper = userMapper;
      }
      @GetMapping("/getall")
    public List<AppUser> getAllUsers() {
          return userService.getAllUsers();
      }
      @GetMapping ("/get")
      AppUser getUserById(UUID id) {

          return userService.getUserById(id);
      }
      @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
          AppUser user =userService.saveUser(dto);
          return ResponseEntity.ok(userMapper.toDto(user));
      }
      @DeleteMapping("/delete")
    public void deleteUser(@RequestParam UUID id) {
          userService.deleteUser(id);
      }
}
