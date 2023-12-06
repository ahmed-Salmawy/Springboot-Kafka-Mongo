package com.example.emailservice.base;

public abstract class AbstractBaseController <s extends BaseService>{
    protected final s service;

    public AbstractBaseController (s service){
        this.service=service;

    }
}
