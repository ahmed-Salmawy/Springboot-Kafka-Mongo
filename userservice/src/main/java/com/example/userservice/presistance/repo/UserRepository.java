package com.example.userservice.presistance.repo;

import com.example.userservice.presistance.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,Long> {

    Optional<UserEntity> findById(long id);
}
