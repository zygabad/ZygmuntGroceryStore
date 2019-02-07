package com.zygstore.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.zygstore.utils.EmailBuilder;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@Named //bean springowy!! named or injected
public class SendEmailService {
    private String emailConfig;
    private String contactData;


    public SendEmailService() throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ReadEmailPropertyValues readEmailConfig = new ReadEmailPropertyValues();
        emailConfig = readEmailConfig.getPropValues();
        sendNewEmail(emailConfig);

    }


    public void sendNewEmail(String emailConfig)
        throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        EmailBuilder newEmailBuilder = new EmailBuilder();
        String firstname = null;
        //String name = BeanUtils.getProperty(contact, firstname);

    }
}
