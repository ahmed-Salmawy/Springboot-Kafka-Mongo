package com.example.emailservice.base;

public interface BaseRepoAdapter  <D extends AbstractBaseDto>{

      long create(D dto);
      void update(D dto);
      void delete(D dto);
      D retrieve(long id);
}
