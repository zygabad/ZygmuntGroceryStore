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
import com.zygstore.utils.EmailUtils;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

@ManagedBean(name = "contactMessageBean", eager = true)
@SessionScoped
public class ContactMessageBean {
//    private static final String CLASSPATH = "applicationContext.xml";
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

    final static Logger logger = Logger.getLogger(ContactMessageBean.class);

    public ContactMessageBean() {
        System.out.println("ContactMessageBean zainicjalizowany !");
        logger.info("ContactMessageBean initialized!");
    }

    public Result send() throws IOException, MessagingException {
        try {
            if (clientAlready == null) {
                this.clientAlready = false;
                this.ticketNumber = "0";
            }
            ContactMessageDTO contactMessageDTO =
                new ContactMessageDTO(firstname, secondname, email, phone, issueType, messageText, clientAlready);
//            ContactMessageService contactMessageService = ctx.getBean(ContactMessageService.class);
            ticketNumber = EmailUtils.generateTicketNumber();
            contactMessageService.send(contactMessageDTO, ticketNumber);
            logger.info("Message sent" + firstname + " " + secondname);

            return Result.SUCCESS;
        } catch (MessagingException ex) {
            logger.error("Cannot send message, reason: ", ex);
        }
        return null;
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
//TODO_DONEinterceptor - przechwytywanie wyjatku i przekirowanie np na error_page i wyswietlenie pop z wyjatkiem, filter, error-handling, web.xml filter
//TODO_DONE na koniec obsluga bledow - jakas generalna , uniwersalna,, popup interceptor/filtr  zanim dostane response przechodze przez interceptora - web.xml
//TODO_DONE kontekst do konstruktora - poczytac bootsfaces ze springiem
//TODO_DONE cd w webxml mozna ustawic interceptory dla beanow czy sciezek a nie @Interceptor(jakisInterceptor.class)
//TODO_DONE - test messagebeana czy nr zgloszenia ustawiony i co mam zwrocone - poprawnie / niepoprawnie
//TODO_DONE nr zgloszenia ? - nazwy parametrow czy ustawiana na wejsciu wyjsciu -inParametr outParametr
//TODO_DONE Mockito in tests - start from simplest things / tests - service where nothing to mock, EMMA plugin code coverage
//TODO_DONE enum do wartosci action do przekirowan - zwracam enuma zamiast tekstu
//TODO_DONE spr w tutorial bootsfacow multipage project jak nawigowac miedzy stronami i przekazywanie danych
//TODO_DONE numer zgloszenia wyswietlic na stronie - zwrocic z servicebeana wartosc i ustwic w fasadzie
//TODO_DONE nawigacja / przekierowanie do facady a nie w backendzie
//TODO_DONE adres poppowrotce z errora jest dalej error
