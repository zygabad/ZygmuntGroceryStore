package com.zygstore.business;

import java.io.IOException;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import com.zygstore.dto.ContactMessageDTO;
import com.zygstore.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
//TODO check if we can comment below bean name
@ManagedBean(name = "contactMessageBean", eager = true)
//@RequestScoped
//@ViewScoped
@SessionScoped
public class ContactMessageBean {

    @Autowired
    private ContactMessageService contactMessageService;

    private String firstname;
    private String secondname;
    private String email;
    private String phone;
    private String issueType;
    private String messageText;
    private Boolean clientAlready;
    ClassPathXmlApplicationContext ctx;
    private String ticketNumber;

    public ContactMessageBean() {
        System.out.println("ContactMessageBean zainicjalizowany !");
    }

    public String send() throws MessagingException, IOException {
        ctx = new ClassPathXmlApplicationContext("application-config.xml");
        ContactMessageDTO contactMessageDTO = new ContactMessageDTO(firstname, secondname, email, phone, issueType, messageText, clientAlready);
        ContactMessageService contactMessageService = ctx.getBean(ContactMessageService.class);
        String result = contactMessageService.send(contactMessageDTO);
        ticketNumber =  contactMessageService.getTicketNumber();
        return result;

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

        //nie testujemy DTO, to struktura danych i nie ma logiki!
    }

    public String clear() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        ctx.stop();
        return "contact_form.xhtml";
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

    public void setContactMessageService(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    public ContactMessageService getContactMessageService() {
        return contactMessageService;
    }

    public void setTicketNumber(String ticketNumber) {

        this.ticketNumber = ticketNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }
}


//TODO obsluga bledow - jakas generalna , uniwersalna,, popup interceptor/filtr  zanim dostane response przechodze przez interceptora
//TODO Mockito in tests
//TODO kontekst do konstruktora - poczytac bootsfaces ze springiem

//TODO enum do wartosci action do przekirowan - zwracam enuma zamiast tekstu
//TODO interceptor - przechwytywanie wyjatku i przekirowanie np na error_page i wyswietlenie pop z wyjatkiem
//TODO nazwy parametrow czy ustawiana na wejsciu wyjsciu -inParametr outParametr
//TODO test messagebeana czy nr zgloszenia ustawiony i co mam zwrocone - poprawnie / niepoprawnie

//TODO DONE spr w tutorial bootsfacow multipage project jak nawigowac miedzy stronami i przekazywanie danych
//TODO DONE numer zgloszenia wyswietlic na stronie - zwrocic z servicebeana wartosc i ustwic w fasadzie
//TODO DONE nawigacja / przekierowanie do facady a nie w backendzie
//TODO DONE adres poppowrotce z errora jest dalej error
