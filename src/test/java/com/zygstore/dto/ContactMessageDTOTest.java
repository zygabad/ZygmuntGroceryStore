package com.zygstore.dto;

import static org.junit.Assert.*;

import com.zygstore.business.ContactMessageBean;
import org.junit.Before;
import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ContactMessageDTOTest {
private static String FIRST_NAME;
private static String SECOND_NAME;
private static String EMAIL;
private static String PHONE;
private ContactMessageDTO contactMessageDTO;

    @Before
    public void setUp() throws Exception {
        FIRST_NAME = "Tesowe Imie";
        SECOND_NAME = "Testowe Nazwisko";
        EMAIL = "Testowy email";
        PHONE = "1234";
    contactMessageDTO = new ContactMessageDTO(FIRST_NAME, SECOND_NAME, EMAIL, PHONE, "issue", "message", true);
    }

    @Test
    public void getFirstname() {
        assertEquals(contactMessageDTO.getFirstname(), FIRST_NAME);
    }

    @Test
    public void getSecondname() {
        assertEquals(contactMessageDTO.getSecondname(), SECOND_NAME);
    }

    @Test
    public void getEmail() {
        assertEquals(contactMessageDTO.getEmail(), EMAIL);
    }

    @Test
    public void getPhone() {
        assertEquals(contactMessageDTO.getPhone(), PHONE);
    }
}