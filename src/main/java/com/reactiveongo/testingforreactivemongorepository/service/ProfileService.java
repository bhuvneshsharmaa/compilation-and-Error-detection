package com.reactiveongo.testingforreactivemongorepository.service;
import com.reactiveongo.testingforreactivemongorepository.model.Profile;
import com.reactiveongo.testingforreactivemongorepository.repo.ProfileRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Service
public class ProfileService {

    private final ApplicationEventPublisher publisher; // <1>
    private final ProfileRepository profileRepository; // <2>
    private static final int Delay=100; //in milli seconds

    ProfileService(ApplicationEventPublisher publisher, ProfileRepository profileRepository) {
        this.publisher = publisher;
        this.profileRepository = profileRepository;
    }

    public Flux<Profile> all() { // <3>
        return this.profileRepository.findAll()
                .delayElements(Duration.ofMillis(Delay));
    }
    public Mono<Profile> add( Profile profile){
        return this.profileRepository.save(profile);
    }

    public Mono<Profile> get(String id) { // <4>
        return this.profileRepository.findById(id);
    }

    public Mono<Profile> update(String id, String email) { // <5>
        return this.profileRepository
                .findById(id)
                .map(p -> new Profile(p.getId(), email))
                .flatMap(this.profileRepository::save);
    }

    public Mono<Profile> delete(String id) { // <6>
        return this.profileRepository
                .findById(id)
                .flatMap(p -> this.profileRepository.deleteById(p.getId()).thenReturn(p));
    }
}