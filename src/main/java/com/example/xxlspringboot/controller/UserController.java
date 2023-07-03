package com.example.xxlspringboot.controller;

import com.example.xxlspringboot.pojo.User;
import com.example.xxlspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping ("/queryUserList")
    public Object queryUserList(){
        return userService.queryUserList();

    }
    @GetMapping ("queryUserById")
    public Object queryUserById(int user_id){
        return userService.queryUserById(user_id);

    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PostMapping("/editUser")
    public String editUser(@RequestBody User user){
        return userService.editUser(user);
    }

    @GetMapping("/deleteUserById")
    public String deleteUserById(int id){
        return userService.deleteUserById(id);

    }
}
