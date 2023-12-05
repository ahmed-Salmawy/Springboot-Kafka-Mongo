package com.example.userservice.domain.repoadapter.impl;

import com.example.userservice.base.AbstractBaseRepoAdapter;
import com.example.userservice.domain.dto.UserDto;
import com.example.userservice.domain.mapper.UserMapper;
import com.example.userservice.domain.repoadapter.UserRegistrationRepoAdapter;
import com.example.userservice.presistance.entity.UserEntity;
import com.example.userservice.presistance.generator.SequenceGeneratorImpl;
import com.example.userservice.domain.repo.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRegistrationRepoAdapterImpl
        extends AbstractBaseRepoAdapter<UserEntity, UserDto, UserMapper,UserRepository>implements
        UserRegistrationRepoAdapter {

    protected UserRegistrationRepoAdapterImpl(UserMapper mapper, UserRepository repository) {
        super(mapper, repository);

    }

    @Override
    public long create(UserDto userDto) {
        UserEntity user = mapper.toEntity(userDto);
        return repository.save(user).getId();
    }

    @Override
    public void update(UserDto dto) {

    }

    @Override
    public void delete(UserDto dto) {

    }

    @Override
    public UserDto retrieve(long id) {
        return repository.findById(id).map(mapper::toDto).orElse(new UserDto());
    }
}
