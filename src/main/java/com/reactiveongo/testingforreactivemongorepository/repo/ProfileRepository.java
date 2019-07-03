package com.reactiveongo.testingforreactivemongorepository.repo;

import com.reactiveongo.testingforreactivemongorepository.model.Profile;
import com.reactiveongo.testingforreactivemongorepository.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProfileRepository extends ReactiveMongoRepository<Profile,String> {
    @Query("{ id: { $exists: true }}")
    Flux<Profile> retrieveAllQuotesPaged(final Pageable page);
}
