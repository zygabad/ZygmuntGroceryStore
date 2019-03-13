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
    String ticketNumber;
    private SendEmailService sendEmailService;

    public ContactMessageService(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    public void send(ContactMessageDTO contactMessageDTO) throws MessagingException, IOException {
        ticketNumber = EmailUtils.generateTicketNumber();
        EmailMessageDTO emailMessageDTO = new EmailMessageDTO(
            contactMessageDTO.getEmail(),
            EmailUtils.generateSubject(ticketNumber),
            EmailUtils.generateText(contactMessageDTO),
            EmailUtils.generateTime());
        sendEmailService.send(emailMessageDTO);
    }

    public String getTicketNumber() {
        return ticketNumber;
    }
}
