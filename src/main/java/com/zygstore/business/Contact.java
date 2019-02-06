package com.zygstore.business;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

@ManagedBean(name = "contact", eager = true)
@RequestScoped
public class Contact {
    private String firstname = "";
    public String secondname;
    public String email;
    public String phone;
    public String issueType;
    public String messageText;
    public Boolean clientAlready;

    public Contact() {
        System.out.println("Bean Contact zainicjalizowany !");
    }

    public Contact(String firstname, String secondname, String email, String phone, String issueType, String messageText,
                   Boolean clientAlready) {
        this.setFirstname(firstname);
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Boolean getClientAlready() {
        return clientAlready;
    }

    public void setClientAlready(Boolean clientAlready) {
        this.clientAlready = clientAlready;
    }

    public String printContact(){
        return "Contact data: !\n" +
            "Imię: " + getFirstname() +
            "\nNazwisko: " + secondname +
            "\nAdres email: " + email +
            "\nTelefon: " + phone +
            "\nTyp Sprawy: " + issueType +
            "\nTreść Wiadomości: " + messageText  +
            "\nNasz Klient: " + clientAlready;
    }
}
