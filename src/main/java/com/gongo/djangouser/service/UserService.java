package com.gongo.djangouser.service;

import com.gongo.djangouser.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(long id);

    User createUser(User user);

    void updateUser(User user);
}
