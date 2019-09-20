package com.zygstore.service;

import java.io.IOException;


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

    private EmailService emailService;

    public ContactMessageService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void send(ContactMessageDTO contactMessageDTO, String ticketNumber) throws MessagingException, IOException {
        EmailMessageDTO emailMessageDTO = new EmailMessageDTO(
            contactMessageDTO.getEmail(),
            EmailUtils.generateSubject(ticketNumber),
            EmailUtils.generateText(contactMessageDTO),
            EmailUtils.generateTime());
        emailService.send(emailMessageDTO);
    }
}
