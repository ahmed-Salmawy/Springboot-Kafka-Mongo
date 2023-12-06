package com.example.emailservice.base;

public interface BaseListener <D extends AbstractBaseDto>{

    void listen(D message);

}
