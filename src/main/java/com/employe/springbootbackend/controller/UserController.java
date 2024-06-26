package com.employe.springbootbackend.controller;

import com.employe.springbootbackend.entity.User;
import com.employe.springbootbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users) {
        return userService.createUsers(users);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @GetMapping ("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @DeleteMapping("user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

}
