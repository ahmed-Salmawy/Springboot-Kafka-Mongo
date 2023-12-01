package com.example.userservice;

import com.example.userservice.domain.dto.UserDto;
import com.example.userservice.domain.service.UserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class tempRunner implements CommandLineRunner {

    @Autowired
    UserRegistrationService userRegistrationService;
    @Override
    public void run(String... args) throws Exception {
        log.info("start adding user into Mongo DB");
     long userId=   userRegistrationService.createUser(UserDto.builder()
                        .email("email.com")
                        .name("ahmed elsalmawy")
                        .mobileNumber("83748923")
                .build());

     log.info("user has been added : {}",userId);

    }
}
