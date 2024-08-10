package com.patika.bloghubservice.repository;

import com.patika.bloghubservice.model.ExceptionLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionLogRepository extends MongoRepository<ExceptionLog,Long> {

}
