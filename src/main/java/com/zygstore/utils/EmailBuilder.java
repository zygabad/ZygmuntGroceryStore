package com.zygstore.utils;

import com.zygstore.business.ContactMessageBean;
import com.zygstore.dto.ContactDTO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
//TODO class builder to builder o okreslonej strukturze. DTO ma miec pola a nie beana w srodku
public class EmailBuilder {
    private ContactDTO contactDTO;
    int identyfikator = 1;

    public EmailBuilder(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
    }

    public EmailData createEmailData(){
        EmailData emailData = new EmailData();
        emailData.setEmailRecipent(contactDTO.getContactMessageBean().email);
        emailData.setEmailText(createEmailText(identyfikator, emailData.getEmailGenerationTime()));
        emailData.setEmailSubject(createEmailSubject());

        return emailData;
    }

    private String createEmailSubject() {
        String subject = "ZygStore eMail wygenerowany automatycznie - prosimy nie odpowiadac.  ";

        return subject;
    }

    private String createEmailText( int identyfikator, String data) {
        String message  = "Witaj " + contactDTO.getContactMessageBean().getFirstname()
            + " " + contactDTO.getContactMessageBean().getSecondname() + "\n"
            + "Dzi\\U+0119kujemy za kontakt\n" + "Twoje zgłoszenie zostalo przyjete i otrzymało identyfikator: "
            + identyfikator + "\n"
            + "Typ zgloszenia: " + contactDTO.getContactMessageBean().getIssueType() + "\n"
            + "Data przyjecia zgłoszenia: " + data + "\n"
            + "Twoje dane: \n" + "email: " + contactDTO.getContactMessageBean().getEmail() + "\n"
            + "telefon: " + contactDTO.getContactMessageBean().getPhone();
        identyfikator++;
        return message;
    }
}
