package com.tutorialspoint.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@ManagedBean(name = "utils", eager = true)
@RequestScoped
public class UtilsZyg {
    public String firstname = "";
    public String secondname;
    public String email;
    public String phone;
    public String typSprawy;
    public String trescWiadomosci;

    public void setTrescWiadomosci(String trescWiadomosci) {
        this.trescWiadomosci = trescWiadomosci;
    }

    public void setTypSprawy(String typSprawy) {
        this.typSprawy = typSprawy;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTypSprawy() {
        return typSprawy;
    }

    public String getTrescWiadomosci() {
        return trescWiadomosci;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public void setName(String firstname) {
        this.firstname = firstname;
    }

    public UtilsZyg(String firstname, String secondname, String email, String phone, String typSprawy, String trescWiadomosci,
                    boolean clientAlready) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.phone = phone;
        this.typSprawy = typSprawy;
        this.trescWiadomosci = trescWiadomosci;
        this.clientAlready = clientAlready;
    }

    private String message = "Message1: Sukces!  Dziękujemy za kontakt. Odpowiemy wkrótce. To jest msg z frameworka jsf\n";;
    //message = "Sukces!  Dziękujemy za kontakt. Odpowiemy wkrótce. To jest msg z frameworka jsf\n" +
    private String message2 ;
    public boolean clientAlready;

    public void setClientAlready(boolean clientAlready) {
        this.clientAlready = clientAlready;
    }

    public boolean isClientAlready() {
        return clientAlready;
    }

    public UtilsZyg() {
        System.out.println("Bean utils zainicjalizowany !");
    }

    public String getMessage() {
        return message;
    }

    public String getMessage2() {
        message2 = read();
        return message2;
    }

    public void printData(){
        System.out.println("Drukuje dane: !" + firstname + " " + secondname + " " +
             email + " " + phone + " " + typSprawy + " " + trescWiadomosci + " " + clientAlready);
    sendMail();
//        this.firstname = firstname;
//        this.secondname = secondname;
//        this.email = email;
//        this.phone = phone;
//        this.issueType = issueType;
//        this.messageText = messageText;
//        this.message = message;
//        this.message2 = message2;
//        this.clientAlready = clientAlready;

    }

    public String wyslijDane () {
        return "Drukuje dane: !" + firstname + " " + secondname + " " +
            email + " " + phone + " " + typSprawy + " " + trescWiadomosci + " " + clientAlready;

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String read(){

        message = "Message2: Sukces!  Dziękujemy za kontakt. Odpowiemy wkrótce. To jest msg z frameworka jsf\n";
        return message;
    }

    public String timeStamp(){
        Date date= new Date();
        Timestamp ts = new Timestamp(date.getTime());
        String timeStamp = ts.toString();
        return timeStamp;
    }

    public void sendMail() {
        //Setting up configurations for the email connection to the Google SMTP server using TLS
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.host", "relayinternal.nykreditnet.net");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("y08l@nykredit.dk", "");
            }
        });

        try {
            //Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);
            String to = "y08l@nykredit.dk";
            InternetAddress[] address = InternetAddress.parse(to, true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject("Sample Mail : " + timeStamp);
            msg.setSentDate(new Date());
            String dane = wyslijDane();
            msg.setText("Sample Zyg Store Generated mail " + dane);
            msg.setHeader("Test email from Zyg Store", "1");
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
    }
}
