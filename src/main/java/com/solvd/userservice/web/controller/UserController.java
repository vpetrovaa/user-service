package com.solvd.userservice.web.controller;

import com.solvd.userservice.domain.User;
import com.solvd.userservice.service.UserService;
import com.solvd.userservice.web.dto.UserDto;
import com.solvd.userservice.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @PostMapping("/registration")
    public UserDto create(@RequestBody @Validated UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userService.create(user);
        userDto = userMapper.toDto(user);
        return userDto;
    }

    @GetMapping("/{email}")
    public boolean isExistByEmail(@PathVariable String email) {
        return userService.isExistByEmail(email);
    }

}
