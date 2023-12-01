package com.example.userservice.base;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class AbstractBaseEntity implements Serializable {

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private String updatedBy;
    private String createdBy;




}