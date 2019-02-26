package com.zygstore.service;

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

    private SendEmailService sendEmailService;

    public ContactMessageService(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    public void send(ContactMessageDTO contactMessageDTO) throws MessagingException {
        EmailMessageDTO emailMessageDTO = new EmailMessageDTO(
            contactMessageDTO.getEmail(),
            "Subject",
            EmailUtils.generateText(contactMessageDTO),
            "generationTime");

        sendEmailService.send(emailMessageDTO);
    }
}
