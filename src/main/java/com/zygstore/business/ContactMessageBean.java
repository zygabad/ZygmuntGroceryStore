package com.zygstore.business;

import java.io.IOException;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import com.zygstore.config.Context;
import com.zygstore.dto.ContactMessageDTO;
import com.zygstore.navigation.Result;
import com.zygstore.service.ContactMessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

@ManagedBean(name = "contactMessageBean", eager = true)
@SessionScoped
public class ContactMessageBean {
    private static final String CLASSPATH = "application-config.xml";
    private ContactMessageService contactMessageService;
    ClassPathXmlApplicationContext ctx;
    private Context context;

    private String firstname;
    private String secondname;
    private String email;
    private String phone;
    private String issueType;
    private String messageText;
    private Boolean clientAlready;
    private String ticketNumber;

    public ContactMessageBean() {
        System.out.println("ContactMessageBean zainicjalizowany !");
    }

    public Result send() throws IOException, MessagingException {
        ContactMessageDTO contactMessageDTO =
            new ContactMessageDTO(firstname, secondname, email, phone, issueType, messageText, clientAlready);
        ContactMessageService contactMessageService = ctx.getBean(ContactMessageService.class);
        contactMessageService.send(contactMessageDTO);
        ticketNumber = contactMessageService.getTicketNumber();
        return Result.SUCCESS;
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

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}


//TODO interceptor - przechwytywanie wyjatku i przekirowanie np na error_page i wyswietlenie pop z wyjatkiem, filter, error-handling, web.xml filter
//TODO na koniec obsluga bledow - jakas generalna , uniwersalna,, popup interceptor/filtr  zanim dostane response przechodze przez interceptora - web.xml
//TODO ---------------------------------------------------------------------------------
//TODO DONE kontekst do konstruktora - poczytac bootsfaces ze springiem
//TODO DONE cd w webxml mozna ustawic interceptory dla beanow czy sciezek a nie @Interceptor(jakisInterceptor.class)
//TODO DONE - test messagebeana czy nr zgloszenia ustawiony i co mam zwrocone - poprawnie / niepoprawnie
//TODO DONE nr zgloszenia ? - nazwy parametrow czy ustawiana na wejsciu wyjsciu -inParametr outParametr
//TODO DONE Mockito in tests - start from simplest things / tests - service where nothing to mock, EMMA plugin code coverage
//TODO DONE enum do wartosci action do przekirowan - zwracam enuma zamiast tekstu
//TODO DONE spr w tutorial bootsfacow multipage project jak nawigowac miedzy stronami i przekazywanie danych
//TODO DONE numer zgloszenia wyswietlic na stronie - zwrocic z servicebeana wartosc i ustwic w fasadzie
//TODO DONE nawigacja / przekierowanie do facady a nie w backendzie
//TODO DONE adres poppowrotce z errora jest dalej error
