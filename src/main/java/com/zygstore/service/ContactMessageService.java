package com.zygstore.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.MessagingException;
import static java.lang.System.out;

import com.zygstore.business.ContactMessageBean;
import com.zygstore.dto.ContactDTO;
import com.zygstore.utils.EmailBuilder;
import com.zygstore.utils.EmailData;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@ManagedBean(name = "contactMessageService", eager = true)
@RequestScoped
public class ContactMessageService {
    private ContactDTO contactDto;

    public ContactMessageService() {
    }

    public ContactMessageService(ContactDTO contactDto) {
        this.contactDto = contactDto;
    }

    public ContactDTO getContactDto() {
        return contactDto;
    }

    public void setContactDto(ContactDTO contactDto) {
        this.contactDto = contactDto;
    }

    public void send() throws MessagingException {
//        String firstName = contactDto.getContactMessageBean().getFirstname();
//        out.println("String First Name from contact message bean : ");
//        out.println("String First Name from contact message bean : " + firstName);
        EmailBuilder emailBuilder = new EmailBuilder(contactDto);
        EmailData emailData = new EmailData();
        emailData = emailBuilder.createEmailData();
        SendEmailService sendEmailService = new SendEmailService(emailData);
        sendEmailService.sendNewEmail();
    }
}
