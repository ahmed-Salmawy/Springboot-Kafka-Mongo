package com.example.userservice.domain.repo;

import com.example.userservice.base.BaseRepository;
import com.example.userservice.presistance.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends BaseRepository<UserEntity,Long> {
    Optional<UserEntity> findById(long id);
}
