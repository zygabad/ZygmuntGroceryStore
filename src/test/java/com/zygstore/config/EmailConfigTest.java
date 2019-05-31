package com.zygstore.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class EmailConfigTest {

    @Test
    public void EmailConfig() {
        EmailConfig emailConfig = new EmailConfig("relayinternal.nykreditnet.net", "y08l@nykredit.dk", "", 25, true);
        assertEquals("relayinternal.nykreditnet.net", emailConfig.getHostName());
        assertEquals("y08l@nykredit.dk", emailConfig.getUsername());
        assertEquals("", emailConfig.getPassword());
        assertEquals(25, emailConfig.getPort());
        assertEquals(true, emailConfig.isAuth());
    }
}