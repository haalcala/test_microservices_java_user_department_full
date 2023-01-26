package com.mycompany.user.service.controller;

import com.mycompany.user.service.VO.ResponseTemplateVO;
import com.mycompany.user.service.entities.User;
import com.mycompany.user.service.services.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("UserController.saveUser::", user.toString());
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO findUserByUserId(@PathVariable("id") Long userId) {
        log.info("UserController.getUserById::");
        return userService.getUserWithDepartment(userId);
    }


}
