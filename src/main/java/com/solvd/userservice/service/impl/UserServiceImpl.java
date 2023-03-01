package com.solvd.userservice.service.impl;

import com.solvd.userservice.domain.User;
import com.solvd.userservice.domain.exception.ResourceAlreadyExistsException;
import com.solvd.userservice.repository.UserRepository;
import com.solvd.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResourceAlreadyExistsException("User with email " + user.getEmail() + " already exists");
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean isExistById(Long id) {
        return userRepository.existsById(id);
    }

}
