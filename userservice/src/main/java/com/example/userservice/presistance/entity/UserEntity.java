package com.example.userservice.presistance.entity;

import com.example.userservice.base.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("userEntity")
@Data

public class UserEntity extends AbstractBaseEntity {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private long id ;
    private String name ;
    private String email;
    private String mobileNumber;
}
