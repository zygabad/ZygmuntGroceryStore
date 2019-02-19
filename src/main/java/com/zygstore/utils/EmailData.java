package com.zygstore.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class EmailData {
    private String emailRecipent;
    private String emailSubject;
    private String emailText;
    private String emailGenerationTime;

    public EmailData() {
        this.emailGenerationTime =  new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());;
    }

    public String getEmailRecipent() {
        return emailRecipent;
    }

    public void setEmailRecipent(String emailRecipent) {
        this.emailRecipent = emailRecipent;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public String getEmailGenerationTime() {
        return emailGenerationTime;
    }


}
