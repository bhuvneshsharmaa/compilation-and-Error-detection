package com.reactiveongo.testingforreactivemongorepository.repo;

import com.reactiveongo.testingforreactivemongorepository.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlockingRepository extends MongoRepository<User,String> {
}
