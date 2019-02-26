package com.zygstore.business;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.MessagingException;

import com.zygstore.dto.ContactMessageDTO;
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

    private ContactMessageService contactMessageService;

    private String firstname;
    private String secondname;
    private String email;
    private String phone;
    private String issueType;
    private String messageText;
    private Boolean clientAlready;

    public ContactMessageBean(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
        System.out.println("ContactMessageBean zainicjalizowany !");
    }

    public void send() throws MessagingException {
        ContactMessageDTO contactMessageDTO = new ContactMessageDTO(firstname, secondname, email, phone, issueType, messageText, clientAlready);
        contactMessageService.send(contactMessageDTO); //tak zamiast co ponizej


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
}
