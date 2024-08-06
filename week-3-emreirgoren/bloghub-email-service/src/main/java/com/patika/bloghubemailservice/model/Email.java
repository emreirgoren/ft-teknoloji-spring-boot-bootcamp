package com.patika.bloghubemailservice.model;

import com.patika.bloghubemailservice.model.enums.EmailTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "emails")
public class Email {

    @Id
    private Long id;

    private String to;
    private EmailTemplate emailTemplate;
    private String emailContent;
    private LocalDateTime createdDateTime;

    public Email(String to, EmailTemplate emailTemplate, String emailContent, LocalDateTime createdDateTime) {
        this.to = to;
        this.emailTemplate = emailTemplate;
        this.emailContent = emailContent;
        this.createdDateTime = createdDateTime;
    }
}
