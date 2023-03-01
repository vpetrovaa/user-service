package com.solvd.userservice.service;

import com.solvd.userservice.domain.User;

public interface UserService {

    User create(User user);

    boolean isExistById(Long id);

}
