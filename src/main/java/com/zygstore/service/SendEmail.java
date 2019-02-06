package com.zygstore.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


import org.apache.commons.beanutils.BeanUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.zygstore.business.Contact;
import com.zygstore.utils.Email;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

@ManagedBean(name = "sendEmail", eager = true)
@RequestScoped
public class SendEmail {
    private String emailConfig;
    private String contactData;


    public SendEmail() throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ReadEmailPropertyValues readEmailConfig = new ReadEmailPropertyValues();
        emailConfig = readEmailConfig.getPropValues();
        sendNewEmail(emailConfig);

    }


    public void sendNewEmail(String emailConfig)
        throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Email newEmail = new Email();
        String firstname = null;
        //String name = BeanUtils.getProperty(contact, firstname);

    }
}
