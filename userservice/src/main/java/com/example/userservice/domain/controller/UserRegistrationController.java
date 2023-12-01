package com.example.userservice.domain.controller;

import com.example.userservice.base.AbstractBaseController;
import com.example.userservice.domain.dto.UserDto;
import com.example.userservice.domain.service.UserRegistrationService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRegistrationController extends AbstractBaseController<UserRegistrationService> {

   @Autowired
    public UserRegistrationController(UserRegistrationService service) {
        super(service);
    }

    @PostMapping
    public long createUser(@RequestBody UserDto userDto){
     return   service.createUser(userDto);

    }


    @GetMapping("/{userId}")
    public UserDto createUser(@PathVariable("userId") long id){
        return   service.getUser(id);

    }
}
