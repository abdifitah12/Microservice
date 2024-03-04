package com.example.insurance.demo.user.impl;

import com.example.insurance.demo.user.User;
import com.example.insurance.demo.user.UserRepository;
import com.example.insurance.demo.user.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    //private  List<User> users = new ArrayList<>();
    UserRepository userRepository;

    private  Long nextId = 1L;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        user.setId(nextId++);
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
       return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean updateUser(Long id, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
               User user = userOptional.get();
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                user.setprofile(updatedUser.getprofile());
                return  true;

        }
        return false;
    }
}
