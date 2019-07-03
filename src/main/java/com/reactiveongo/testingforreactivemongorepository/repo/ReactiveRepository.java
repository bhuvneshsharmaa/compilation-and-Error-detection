package com.reactiveongo.testingforreactivemongorepository.repo;

import com.reactiveongo.testingforreactivemongorepository.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactiveRepository  extends ReactiveMongoRepository<User,String> {
}
