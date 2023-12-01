package com.example.userservice.domain.mapper;

import com.example.userservice.base.BaseMapper;
import com.example.userservice.domain.dto.UserDto;
import com.example.userservice.presistance.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper implements BaseMapper<UserEntity, UserDto> {
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public UserDto toDto(UserEntity entity) {
        return mapper.map(entity, UserDto.class);
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        return mapper.map(dto, UserEntity.class);
    }
}
