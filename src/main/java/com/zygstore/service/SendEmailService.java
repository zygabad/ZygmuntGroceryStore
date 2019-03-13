package com.zygstore.service;


import java.io.IOException;
import java.util.Date;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static java.lang.System.out;

import com.zygstore.config.EmailConfig;
import com.zygstore.dto.EmailMessageDTO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
//@NamedBean//@Named //bean springowy!! named or injected
public class SendEmailService {

    private EmailConfig emailConfig;

    public SendEmailService(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    public boolean send(EmailMessageDTO emailMessageDTO) throws MessagingException {
            MimeMessage msg = createMimeMessage(emailMessageDTO);
            Transport.send(msg);
            out.println("Mail has been sent successfully");
            return true;
    }

    public MimeMessage createMimeMessage (EmailMessageDTO emailMessageDTO) throws MessagingException {
        MimeMessage msg = new MimeMessage(emailConfig.getSession());
        InternetAddress[] address = InternetAddress.parse(emailMessageDTO.getEmailRecipent(), true);
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(emailMessageDTO.getEmailSubject());
        msg.setSentDate(new Date());
        msg.setText(emailMessageDTO.getEmailText());
        msg.setHeader("Content-Type", "text/plain; charset=UTF-8");
        return msg;
    }
}
