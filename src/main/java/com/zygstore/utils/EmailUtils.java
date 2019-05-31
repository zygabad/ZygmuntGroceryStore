package com.zygstore.utils;

import java.util.Calendar;
import java.util.Date;


import com.zygstore.dto.ContactMessageDTO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class EmailUtils {
    private static long ticketCounter;


    private EmailUtils() {
        //private constructor
    }

    public static String generateText(ContactMessageDTO contactMessageDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Witaj " + contactMessageDTO.getFirstname() + " " + contactMessageDTO.getSecondname());
        stringBuilder.append(",\n\n");
        stringBuilder.append("Przyjęlismy zgłoszenie.");

        return stringBuilder.toString();
    }

    public static String generateSubject(String ticketNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ZygStore - Przyjeto zgłoszenie");
        stringBuilder.append(",\n\n");
        stringBuilder.append("Twoje zgłoszenie otrzymało numer: " + ticketNumber);
        return stringBuilder.toString();
    }

    public static String generateTime() {
        Date generationTimeDate = new Date();
        return generationTimeDate.toString();
    }

    public static String generateTicketNumber() {
        Date date = null; // your date
        int year = 0;
        int month = 0;
        int day = 0;

        ticketCounter++;
        date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

        String ticketNumber = ticketCounter + "/" + year + "/" + month + "/" + day;
        return ticketNumber;
    }
}
