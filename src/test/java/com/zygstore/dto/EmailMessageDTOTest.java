package com.zygstore.dto;

import static org.junit.Assert.*;

import com.zygstore.service.ContactMessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class EmailMessageDTOTest {
    private static String EMAIL_RECIPENT = null;
    private static String EMAIL_SUBJECT = null;
    private static String EMAIL_TEXT = null;
    private EmailMessageDTO emailMessageDTO;



    @Before
    public void setUp() throws Exception {
        EMAIL_RECIPENT = "testowy@email.com";
        EMAIL_SUBJECT = "Testowy Subject";
        EMAIL_TEXT = "Testowa tresc maila";
        emailMessageDTO = new EmailMessageDTO(EMAIL_RECIPENT, EMAIL_SUBJECT,EMAIL_TEXT, "TimeDate");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getEmailRecipent() {
        assertEquals(emailMessageDTO.getEmailRecipent(), EMAIL_RECIPENT);
    }

    @Test
    public void getEmailSubject() {
        assertEquals(emailMessageDTO.getEmailSubject(), EMAIL_SUBJECT);
    }

    @Test
    public void getEmailText() {
        assertEquals(emailMessageDTO.getEmailText(), EMAIL_TEXT);
    }
}