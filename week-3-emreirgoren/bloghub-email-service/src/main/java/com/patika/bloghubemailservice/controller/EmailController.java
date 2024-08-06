package com.patika.bloghubemailservice.controller;

import com.patika.bloghubemailservice.dto.request.EmailCreateRequest;
import com.patika.bloghubemailservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public void sendEmail(@RequestBody EmailCreateRequest request){
        emailService.sendEmail(request);
    }


}
