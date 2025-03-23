package com.dilshanpathirage.portfolio.DilshanPathiragePortfolio;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String sendEmail(Email email) {

        Email getEmail = new Email();
        getEmail.setName(email.getName());
        getEmail.setEmailAddress(email.getEmailAddress());
        getEmail.setDescription(email.getDescription());

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);


            helper.setFrom("usernamex1995@gmail.com");
            helper.setTo("danidutharuka12345@gmail.com");
            helper.setSubject("Project Oder");

            String htmlContent = "<html>"
                    + "<body style='font-family: Arial, sans-serif;'>"
                    + "<div style='border: 1px solid #ddd; padding: 20px; max-width: 600px; margin: 0 auto;'>"
                    + "<h2 style='color: #4CAF50;'>New Project Oder</h2>"
                    + "<p>Dear Dilshan Pathirage,</p>"
                    + "<p>Please Find This Email</p>"
                    + "<div style='background-color: #f4f4f4; padding: 10px; margin: 20px 0;'>"
                    + "<p><strong>Client Name :</strong> " + email.getName() + "</p>"
                    + "<p><strong>Client Email :</strong> " + email.getEmailAddress() + "</p>"
                    + "</div>"
                    + "<p><strong>Project Description :</strong> " + email.getDescription() + " </p>"
                    + "<p>Best regards,<br>" + email.getName() + "</p>"
                    + "</div>"
                    + "</body>"
                    + "</html>";

            helper.setText(htmlContent, true);

            javaMailSender.send(message);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }


}
