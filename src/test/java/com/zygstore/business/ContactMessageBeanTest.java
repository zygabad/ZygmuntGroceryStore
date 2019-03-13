package com.zygstore.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.zygstore.dto.ContactMessageDTO;
import com.zygstore.service.ContactMessageService;
import com.zygstore.service.SendEmailService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ContactMessageBeanTest {
    private static final String TICKET_NUMBER = "1/2019/02/11";
    private static final String FIRST_NAME = "FirstName";
    private static final String SECOND_NAME = "SecondName";
    private static final String EMAIL = "Email";
    private static final String PHONE = "Phone";


    ContactMessageBean contactMessageBean;
    ContactMessageService contactMessageService;
    ContactMessageDTO contactMessageDTO;
    ClassPathXmlApplicationContext ctx;

    @Before
    public void setUp() throws Exception {
        contactMessageDTO = new ContactMessageDTO(FIRST_NAME, SECOND_NAME, EMAIL, PHONE, "", "", true);
        SendEmailService sendEmailService = mock(SendEmailService.class);
        contactMessageService = new ContactMessageService(sendEmailService);
        contactMessageBean = new ContactMessageBean();
        contactMessageService.send(contactMessageDTO);

    }

    @Test
    public void sendResult() {
        //when(contactMessageBean.getTicketNumber()).thenReturn("12019");
        assertEquals("SUCCESS", contactMessageBean.send());
    }
}