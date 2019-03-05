package com.zygstore.service;

import java.io.IOException;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import com.zygstore.dto.ContactMessageDTO;
import com.zygstore.dto.EmailMessageDTO;
import com.zygstore.utils.EmailUtils;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ContactMessageService {
    boolean sendingEmailResult = false;
    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

    private SendEmailService sendEmailService;

    public ContactMessageService(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    public void send(ContactMessageDTO contactMessageDTO) throws MessagingException, IOException {
        EmailMessageDTO emailMessageDTO = new EmailMessageDTO(
            contactMessageDTO.getEmail(),
            EmailUtils.generateSubject(),
            EmailUtils.generateText(contactMessageDTO),
            EmailUtils.generateTime());

        sendingEmailResult = sendEmailService.send(emailMessageDTO);
        navigate(sendingEmailResult);
    }

    private void navigate(boolean sendingEmailResult) {
        try {
            if (sendingEmailResult) {

                context.redirect(context.getRequestContextPath() + "contact_form_success.xhtml");

            } else {
                context.redirect(context.getRequestContextPath() + "contact_form_error.xhtml?");
                //context.redirect(context.getRequestContextPath() + "contact_form_error.xhtml?" + e);
                //TODO Jak tutaj przechwycic wyjatek z wysylki? Mialem event e w SendEmailService
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
