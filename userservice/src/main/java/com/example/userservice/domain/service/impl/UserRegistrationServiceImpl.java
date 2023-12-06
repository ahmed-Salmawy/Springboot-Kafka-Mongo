package com.example.userservice.domain.service.impl;

import com.example.userservice.aspect.notification.UserRegNotify;
import com.example.userservice.base.AbstractBaseService;
import com.example.userservice.domain.dto.UserDto;
import com.example.userservice.domain.repoadapter.UserRegistrationRepoAdapter;
import com.example.userservice.domain.service.UserRegistrationService;
import org.springframework.stereotype.Service;
@Service
class UserRegistrationServiceImpl
        extends AbstractBaseService<UserDto, UserRegistrationRepoAdapter> implements UserRegistrationService {

    protected UserRegistrationServiceImpl(UserRegistrationRepoAdapter repoAdapter) {
        super(repoAdapter);
    }

    @Override
    @UserRegNotify
    public long createUser(UserDto user) {
        return repoAdapter.create(user);
    }

    @Override
    public UserDto getUser(long id) {
        return repoAdapter.retrieve(id);
    }
}
