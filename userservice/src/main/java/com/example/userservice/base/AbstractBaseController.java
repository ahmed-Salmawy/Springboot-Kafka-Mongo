package com.example.userservice.base;

public abstract class AbstractBaseController <s extends BaseService>{
    protected final s service;

    public AbstractBaseController (s service){
        this.service=service;

    }
}
