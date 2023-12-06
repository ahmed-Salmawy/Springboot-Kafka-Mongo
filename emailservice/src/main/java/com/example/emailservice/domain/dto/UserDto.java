package com.example.emailservice.domain.dto;

import com.example.emailservice.base.AbstractBaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends AbstractBaseDto {
    private long id ;
    private String name ;
    private String email;
    private String mobileNumber;

}
