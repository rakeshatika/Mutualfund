package com.vcube.Mutualfund.service;

import java.util.List;
import com.vcube.Mutualfund.entity.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}