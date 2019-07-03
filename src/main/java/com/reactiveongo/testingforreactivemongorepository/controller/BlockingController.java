package com.reactiveongo.testingforreactivemongorepository.controller;

import com.reactiveongo.testingforreactivemongorepository.service.CompilerService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/block")
public class BlockingController {
    private final CompilerService compilerService;
    public BlockingController(CompilerService compilerService){
        this.compilerService=compilerService;
    }

    @GetMapping("/run")
    public String add(@RequestParam String lang,
                      @RequestBody String code,
                      @RequestParam String input) throws IOException {
        return compilerService.runCode(code,lang,input);
    }
}
