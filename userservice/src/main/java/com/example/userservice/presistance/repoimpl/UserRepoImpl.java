package com.example.userservice.presistance.repoimpl;

import com.example.userservice.base.SequenceGenerator;
import com.example.userservice.domain.repo.UserRepository;
import com.example.userservice.presistance.entity.UserEntity;
import com.mongodb.client.MongoClient;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepoImpl extends AbstractBaseRepo<UserEntity, Long> implements UserRepository {


    @Autowired
    protected UserRepoImpl( MongoTemplate mongoTemplate, SequenceGenerator sequenceGenerator) {
        super(UserEntity.class, mongoTemplate, sequenceGenerator);
    }

    @Override
    public Optional<UserEntity> findById(long id) {
        return Optional.ofNullable(findOne(id));
    }
}
