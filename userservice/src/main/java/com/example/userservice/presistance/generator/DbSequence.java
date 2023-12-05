package com.example.userservice.presistance.generator;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("db_sequences")
@Data
public class DbSequence {
    @Id
    private String id;
    private long seq;
}
