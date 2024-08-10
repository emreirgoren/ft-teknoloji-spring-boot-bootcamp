package com.patika.bloghubservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Getter
@Setter
@Entity
@Document(collection = "exceptions")
public class ExceptionLog {

    @Id
    private String id;
    private String exception;
}
