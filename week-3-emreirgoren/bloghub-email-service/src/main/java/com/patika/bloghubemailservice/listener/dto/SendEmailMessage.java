package com.patika.bloghubemailservice.listener.dto;

import com.patika.bloghubemailservice.model.enums.EmailTemplate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SendEmailMessage {

    private String to;
    private EmailTemplate emailTemplate;

}
