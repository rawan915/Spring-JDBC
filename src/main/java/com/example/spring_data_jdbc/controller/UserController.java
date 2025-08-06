package com.example.spring_data_jdbc.controller;


import com.example.spring_data_jdbc.model.User;
import com.example.spring_data_jdbc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

// 1. Add new user
// 2. Get user by ID
// 3. Get user by username
// 4. Update user
// 5. Delete user
// 6. Get all user
// 7. Login


@PostMapping
    public User addNewUser(@RequestBody User user) {
     return service.addNewUser(user);
}


@GetMapping("/ById/{id}")
    public User getById(@PathVariable int id){
    return  service.findById(id);
}

@GetMapping("/ByUsername/{username}")
    public User getByUsername(@PathVariable String username){
    return service.getByUsername(username);
}
@PutMapping
public void updateUser(@RequestBody User user) {
     service.updateUser(user);
}
@DeleteMapping("/Delete/{id}")
    public void deleteById(@PathVariable int id) {
     service.deleteUser(id);
}
@GetMapping
public List<User> getAll() {
    return service.findAll();
}
    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return service.login(username, password);
    }

}
