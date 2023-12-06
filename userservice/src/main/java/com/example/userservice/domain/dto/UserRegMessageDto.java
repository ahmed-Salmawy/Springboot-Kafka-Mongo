package com.example.userservice.domain.dto;

import com.example.userservice.base.AbstractBaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegMessageDto  extends AbstractBaseDto {

    private String to ;
    private String cc;
    private String bcc;
    private String body;

}
