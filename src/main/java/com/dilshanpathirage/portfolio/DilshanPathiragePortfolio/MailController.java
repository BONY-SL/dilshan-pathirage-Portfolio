package com.dilshanpathirage.portfolio.DilshanPathiragePortfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-email")
public class MailController {

    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> sendMail(@RequestBody Email email) {
        String result = mailService.sendEmail(email);
        return ResponseEntity.ok(result);
    }

}
