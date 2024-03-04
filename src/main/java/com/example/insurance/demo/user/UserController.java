package com.example.insurance.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class UserController {
   private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping("/users")
    public ResponseEntity<String> createUsers(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>("User added successfully ", HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        if(user != null)
            return  new ResponseEntity<>(user, HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity <String> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUserById(id);
        if(deleted)
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users/{id}")
    public  ResponseEntity <String> updateUser(@PathVariable Long id,
                                                @RequestBody User updatedUser){
        boolean update =  userService.updateUser(id , updatedUser);
        if(update)
            return new ResponseEntity<>("User updated successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
