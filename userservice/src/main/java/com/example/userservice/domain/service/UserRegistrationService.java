package com.example.userservice.domain.service;

import com.example.userservice.base.BaseService;
import com.example.userservice.domain.dto.UserDto;

public interface UserRegistrationService extends BaseService {
    long createUser(UserDto user);


    UserDto getUser(long id);
}
