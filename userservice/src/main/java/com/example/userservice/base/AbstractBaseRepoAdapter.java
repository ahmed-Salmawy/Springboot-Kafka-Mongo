package com.example.userservice.base;

import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class AbstractBaseRepoAdapter <E extends AbstractBaseEntity,D extends AbstractBaseDto
        ,M extends BaseMapper<E,D>,R extends MongoRepository<E,Long> >
implements BaseRepoAdapter<D>
{

    protected final M mapper;
    protected final R repository;
    protected final SequenceGenerator sequenceGenerator;
    protected AbstractBaseRepoAdapter(M mapper, R repository, SequenceGenerator sequenceGenerator) {
        this.mapper = mapper;
        this.repository = repository;
        this.sequenceGenerator=sequenceGenerator;
    }





}
