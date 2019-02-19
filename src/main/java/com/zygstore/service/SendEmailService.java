package com.zygstore.service;

import java.util.Date;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.zygstore.utils.EmailData;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
//@Named //bean springowy!! named or injected
public class SendEmailService {
    private String emailConfig;
    private EmailData emailData;
//    public SendEmailService() throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        ReadEmailPropertyValues readEmailConfig = new ReadEmailPropertyValues();
//        emailConfig = readEmailConfig.getPropValues();
//        sendNewEmail(emailConfig);
//
//    }


    public SendEmailService(EmailData emailData) {
        this.emailData = emailData;
    }

    public void sendNewEmail() throws MessagingException {
        //Setting up configurations for the email connection to the Google SMTP server using TLS
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.host", "relayinternal.nykreditnet.net");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("y08l@nykredit.dk", "");
            }
        });

        MimeMessage msg = new MimeMessage(session);
        InternetAddress[] address = InternetAddress.parse(emailData.getEmailRecipent(), true);
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(emailData.getEmailSubject());
        msg.setSentDate(new Date());
        msg.setText(emailData.getEmailText());
        msg.setHeader("Content-Type", "text/plain; charset=UTF-8");
        Transport.send(msg);
        System.out.println("Mail has been sent successfully");
    }
}
