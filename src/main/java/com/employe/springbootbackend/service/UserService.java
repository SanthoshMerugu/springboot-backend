package com.employe.springbootbackend.service;

import com.employe.springbootbackend.dao.UserRepository;
import com.employe.springbootbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);

    }
    public List<User> createUsers(List<User> users) {
     return userRepository.saveAll(users);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User updateUser(User user) {
        User oldUser = null;
        Optional<User> optionalUser= userRepository.findById(user.getId());
        if(optionalUser.isPresent()) {
            oldUser = optionalUser.get();
           oldUser.setName(user.getName());
           oldUser.setAddress(user.getAddress());
           userRepository.save(oldUser);
        } else {
            return new User();
        }
        return oldUser;
    }

    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "User deleted";
    }


}
