package com.reactiveongo.testingforreactivemongorepository.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String code;
    private String input;
    private String error;
    private String output;
    private String language;
}
