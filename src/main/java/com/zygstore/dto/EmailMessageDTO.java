package com.zygstore.dto;


/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class EmailMessageDTO {
    private String emailRecipent;
    private String emailSubject;
    private String emailText;
    private String emailGenerationTime;

    public EmailMessageDTO(String emailRecipent, String emailSubject, String emailText, String emailGenerationTime) {
        this.emailRecipent = emailRecipent;
        this.emailSubject = emailSubject;
        this.emailText = emailText;
        this.emailGenerationTime = emailGenerationTime;
    }

    public String getEmailRecipent() {
        return emailRecipent;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public String getEmailText() {
        return emailText;
    }

    public String getEmailGenerationTime() {
        return emailGenerationTime;
    }
}
