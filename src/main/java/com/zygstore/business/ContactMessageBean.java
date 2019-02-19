package com.zygstore.business;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.MessagingException;

import com.zygstore.dto.ContactDTO;
import com.zygstore.service.ContactMessageService;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
//TODO check if we can comment below bean name
@ManagedBean(name = "contactMessageBean", eager = true)
@RequestScoped
public class ContactMessageBean {
    private String firstname = "";
    public String secondname;
    public String email;
    public String phone;
    public String issueType;
    public String messageText;
    public Boolean clientAlready;

    private ContactDTO contact1;

    public ContactMessageBean() {
        System.out.println("Bean Contact zainicjalizowany !");
    }

    public ContactMessageBean(String firstname, String secondname, String email, String phone, String issueType, String messageText,
                              Boolean clientAlready) {
        this.setFirstname(firstname);
        this.secondname = secondname;
        this.email = email;
        this.phone = phone;
        this.issueType = issueType;
        this.messageText = messageText;
        this.clientAlready = clientAlready;
    }

    public ContactDTO getContact1() {
        return contact1;
    }

    public void setContact1(ContactDTO contact1) {
        this.contact1 = contact1;
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

    public String printContact() {
        return "Contact data: !\n" +
            "Imię: " + getFirstname() +
            "\nNazwisko: " + secondname +
            "\nAdres email: " + email +
            "\nTelefon: " + phone +
            "\nTyp Sprawy: " + issueType +
            "\nTreść Wiadomości: " + messageText +
            "\nNasz Klient: " + clientAlready;
    }

    public void send() throws MessagingException {
        ContactDTO contact = new ContactDTO(this);
        ContactMessageService contactMessageService = new ContactMessageService(contact);
        contactMessageService.send(); //tak zamiast co ponizej


        //inversion of control - gdzie indziej inicjalizuje gdzie indziej uzywam , dependency inj
        //springa lub jee
        //services nie maja stanow - bezstanowe, utile, validatory nie maja stanow - tylko funkcje
        //managed beany sa stanowe

        //util vs service - service wola cos jeszcze a util juz nic nie wola, zazwyczaj metody statyczne, ktorych nie mokujemy
        //util to cos czego nie musze mockowac , nt operacje na dacie,
        //service tworze
        //TESTY!!!! servicow - beanow nie testowac i dao nie testujemy
        //Obsluga wyjatkow jak zrobic
        //helper = util
        //w messydzbean wywolue contactDTOBuilder i przekazuje parametry albo this , builder buduje mi obiekt contactdto
        //w COntactDTO nie powininenm miec beana ContactMessydz
        //wzorzec builder, visitor
        //wzorzec factory - abstract factory , fabryka abstrakcyjna

    }
}
