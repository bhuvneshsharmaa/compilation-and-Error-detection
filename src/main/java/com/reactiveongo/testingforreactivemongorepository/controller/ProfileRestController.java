package com.reactiveongo.testingforreactivemongorepository.controller;
import com.reactiveongo.testingforreactivemongorepository.model.Profile;
import com.reactiveongo.testingforreactivemongorepository.service.ProfileService;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController // <1>
@RequestMapping(value = "/profiles")  // <2>
class ProfileRestController {

    private final ProfileService profileRepository;

    ProfileRestController(ProfileService profileRepository) {
        this.profileRepository = profileRepository;
    }
//    @GetMapping(value = "/reactive")
//    Flux<Profile> getall(){
//        return this.profileRepository.all().blockFirst();
//    }

    // <3>
    @GetMapping
    Publisher<Profile> getAll() {
        return this.profileRepository.all();
    }
    @GetMapping(value="/stream")
    Flux<Profile> getAllStream() {
        return this.profileRepository.all();
    }
    @PostMapping
    Mono<Profile> add(@RequestBody Profile profile){
        return this.profileRepository.add(profile);
    }

    // <4>
    @GetMapping("/{id}")
    Publisher<Profile> getById(@PathVariable("id") String id) {
        return this.profileRepository.get(id);
    }

    @DeleteMapping("/{id}")
    Publisher<Profile> deleteById(@PathVariable String id) {
        return this.profileRepository.delete(id);
    }

    @PutMapping("/{id}")
    Publisher<Profile> updateById(@PathVariable String id, @RequestBody Profile profile) {
        return Mono
                .just(profile)
                .flatMap(p -> this.profileRepository.update(id, p.getEmail()));
    }
}
