//package com.reactiveongo.testingforreactivemongorepository.service;
//
//import com.reactiveongo.testingforreactivemongorepository.model.Profile;
//import com.reactiveongo.testingforreactivemongorepository.repo.BlockingRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BlockingService {
//    private final BlockingRepository blockingRepository;
//    private static final int Delay=100; //in milli seconds
//    public BlockingService(final BlockingRepository blockingRepository){
//        this.blockingRepository=blockingRepository;
//    }
//    public List<Profile> all() throws Exception { // <3>
//        Thread.sleep(Delay * blockingRepository.count());
//        return this.blockingRepository.findAll();
//    }
//    public Profile add( Profile profile){
//        return this.blockingRepository.save(profile);
//    }
////
////
////    public Profile get(String id) { // <4>
////        return this.blockingRepository.findById(id);
////    }
////
////    public Profile update(String id, String email) { // <5>
////        return this.blockingRepository
////                .findById(id)
////                .map(p -> new Profile(p.getId(), email))
////                .flatMap(this.blockingRepository::save);
////    }
////
////    public Profile delete(String id) { // <6>
////        return this.profileRepository
////                .findById(id)
////                .flatMap(p -> this.profileRepository.deleteById(p.getId()).thenReturn(p));
////    }
//}
