package com.dilshanpathirage.portfolio.DilshanPathiragePortfolio;

import org.springframework.stereotype.Component;

@Component
public class Email {

    private String name;
    private String emailAddress;
    private String description;

    // Getter methods
    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDescription() {
        return description;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
