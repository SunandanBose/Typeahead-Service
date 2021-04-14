package com.search.practice.search.controller;

import com.search.practice.search.model.Search;
import com.search.practice.search.model.User;
import com.search.practice.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/bulk/create")
    public void bulkInsert(@RequestBody List<User> users) {
//        User user = new User(123, 345, "Sunandan Bose", "ABC", "Assignment", "Jamshedpur", "Arizona", "abc", "India");
        userService.createUserIndexBulk(users);
    }

    @GetMapping(value = "/search/displayname")
    public List<User> searchDisplayName(@RequestParam(value = "searchTerm") String searchTerm) {
        return userService.search(searchTerm);
    }

    @GetMapping(value = "/search")
    public List<User> search(@RequestBody Search search) {
        return userService.search(search);
    }

    @GetMapping(value = "/count")
    public Integer count(@RequestBody Search search) {
        return userService.count(search);
    }
}
