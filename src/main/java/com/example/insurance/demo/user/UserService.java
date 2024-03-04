package com.example.insurance.demo.user;

import java.util.List;

public interface UserService {
    List<User>findAll();
    void createUser(User user);

    User getUserById(Long id);

    boolean deleteUserById(Long id);

    boolean updateUser(Long id, User updatedUser);
}
