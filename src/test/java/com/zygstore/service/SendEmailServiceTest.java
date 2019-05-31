package com.zygstore.service;

import java.io.IOException;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.zygstore.config.EmailConfig;
import com.zygstore.dto.ContactMessageDTO;
import com.zygstore.dto.EmailMessageDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@RunWith(MockitoJUnitRunner.class)
public class SendEmailServiceTest {

    private static final String HOST_NAME = "relayinternal.nykreditnet.net";
    private static final String USER_NAME = "y08l@nykredit.dk";
    private static final String SECOND_NAME = "Nazwisko";
    private static final String FIRST_NAME = "Imie";
    private static final int PORT = 25;
    private static final boolean AUTH = true;
    private static final boolean CLIENT_ALREADY = true;
    private static final String PHONE = "+48604532456";
    private static final String ISSUE_TYPE = "Faktury";
    private static final String MESSAGE_TEXT = "Text wiadomosci";
    private static final String EMAIL_RECIPENT = "y08l@nykredit.dk";
    private static final String SUBJECT = "Subject";
    private static final String EMAIL_TEXT = "Tresc wiadomosci";
    private static final String EMAIL_DATE = "20190305";


    private SendEmailService sendEmailService;
    private EmailMessageDTO emailMessageDTO;
    private MimeMessage mimeMessage;

    @Before
    public void setUp() throws Exception {
        EmailConfig emailConfig = new EmailConfig(HOST_NAME, USER_NAME, "", PORT, AUTH);
        ContactMessageDTO contactMessageDTO = new ContactMessageDTO(FIRST_NAME, SECOND_NAME, "", PHONE,
            ISSUE_TYPE, MESSAGE_TEXT, CLIENT_ALREADY);
        emailMessageDTO = new EmailMessageDTO(
            EMAIL_RECIPENT,
            SUBJECT,
            EMAIL_TEXT,
            EMAIL_DATE);
        sendEmailService = new SendEmailService(emailConfig);
        mimeMessage = sendEmailService.createMimeMessage(emailMessageDTO);
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void TestSendEmail() throws IOException, MessagingException {
//        //given
//        //when
//        boolean ret = sendEmailService.send(emailMessageDTO);
//        //done
//        Assert.assertTrue(ret);
//    }

    @Test
    public void TestEmailWithoutSending() throws MessagingException, IOException {
        Assert.assertTrue(mimeMessage.getRecipients(Message.RecipientType.TO)[0].toString().equals(EMAIL_RECIPENT));
        Assert.assertEquals(mimeMessage.getRecipients(Message.RecipientType.TO)[0].toString(), EMAIL_RECIPENT);
    }
}