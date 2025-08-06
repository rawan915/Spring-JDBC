package com.example.spring_data_jdbc.service;

import com.example.spring_data_jdbc.model.User;
import com.example.spring_data_jdbc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User addNewUser(User user) {
         repo.addNewUser(user);
        return user;
    }


    public User findById(int id ) {
        return repo.findById(id);
    }

    public User getByUsername(String username) {
        return repo.findByUserName(username);
    }

    public void updateUser(User user) {
        repo.updateUser(user);
    }


    public void deleteUser(int id) {
         repo.deleteUser(id);
    }

    public List<User> findAll() {
        return repo.findall();
    }

    public User login(String username, String password) {
        return repo.login(username, password);
    }
}
