package com.zygstore.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
//@NamedBean
//@ManagedBean(name = "contactMessageDTO", eager = true)
//@Component
//@Scope("session")
public class ContactMessageDTO {

    //@Autowired
    private String firstname;
    //@Autowired
    private String secondname;
    private String email;
    private String phone;
    private String issueType;
    private String messageText;
    private Boolean clientAlready;

    public ContactMessageDTO(String firstname, String secondname, String email, String phone, String issueType, String messageText,
                             Boolean clientAlready) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.phone = phone;
        this.issueType = issueType;
        this.messageText = messageText;
        this.clientAlready = clientAlready;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getMessageText() {
        return messageText;
    }

    public Boolean getClientAlready() {
        return clientAlready;
    }


}
