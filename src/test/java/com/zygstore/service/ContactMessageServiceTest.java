package com.zygstore.service;

import java.util.Calendar;
import java.util.Date;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.zygstore.dto.ContactMessageDTO;
import org.junit.Before;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ContactMessageServiceTest {
    private ContactMessageDTO contactMessageDTO;
    private EmailService emailService;
    private ContactMessageService contactMessageService;
    private String computedTicketNumber;

    @Before
    public void setUp() throws Exception {
        contactMessageDTO = mock(ContactMessageDTO.class);
        emailService = mock(EmailService.class);
        contactMessageService = new ContactMessageService(emailService);
        computedTicketNumber = computeTicketNumber();
    }

    /*@Test
    public void getTicketNumber() throws IOException, MessagingException {
        contactMessageService.send(contactMessageDTO);
        assertEquals(computedTicketNumber, contactMessageService.getTicketNumber());
    }*/

    private String computeTicketNumber() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return "1/" + cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH);
    }

}