package com.example.userservice.presistance.repoimpl;

import com.example.userservice.base.AbstractBaseEntity;
import com.example.userservice.base.BaseRepository;
import com.example.userservice.base.SequenceGenerator;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReplaceOneModel;
import org.bson.BsonDocument;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.ReturnDocument.AFTER;
import static org.springframework.data.mongodb.core.FindAndReplaceOptions.options;
import static org.springframework.data.mongodb.core.query.Query.query;

public abstract class AbstractBaseRepo<E extends AbstractBaseEntity, ID> implements BaseRepository<E, ID> {

    private final Class<E> entityTypeClass;
    protected static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();


    private final MongoTemplate mongoTemplate;

    private final SequenceGenerator sequenceGenerator;


    protected AbstractBaseRepo(Class<E> entityTypeClass, MongoTemplate mongoTemplate, SequenceGenerator sequenceGenerator) {
        this.entityTypeClass = entityTypeClass;
        this.mongoTemplate = mongoTemplate;
        this.sequenceGenerator = sequenceGenerator;
    }


    public E save(E entity) {
        entity.setId(sequenceGenerator.generateSequence(entity.getSequenceName()));
        mongoTemplate.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public List<E> saveAll(List<E> entities) {
        entities.forEach(p -> p.setId(sequenceGenerator.generateSequence(p.getSequenceName())));
        mongoTemplate.insertAll(entities);
        return entities;
    }


    @Override
    public List<E> findAll() {
        return mongoTemplate.findAll(entityTypeClass);
    }

    @Override
    public List<E> findAll(List<ID> ids) {
        Query query = new Query(Criteria.where("_id").in(ids));
        return mongoTemplate.find(query, entityTypeClass);
    }

    @Override
    public E findOne(ID id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, entityTypeClass);

    }

    @Override
    public long count() {
        return mongoTemplate.count(new Query(), entityTypeClass);
    }

    @Override
    public long delete(ID id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.remove(query, entityTypeClass).getDeletedCount();
    }

    @Override
    @Transactional
    public long delete(List<ID> ids) {

        return mongoTemplate.remove(query(Criteria.where("_id").in(ids)), entityTypeClass).getDeletedCount();
    }

    @Override
    public long deleteAll() {
        return mongoTemplate.remove(new Query(), entityTypeClass).getDeletedCount();
    }

    @Override
    public E update(E entity) {

        return mongoTemplate.findAndReplace(query(Criteria.where("_id").is(entity.getId())), entity, options().returnNew());
    }

    @Override
    public long update(List<E> entities) {
        return 0L;
    }

}
