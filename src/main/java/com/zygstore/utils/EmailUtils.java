package com.zygstore.utils;

import com.zygstore.dto.ContactMessageDTO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class EmailUtils {

    private EmailUtils() {
        //private constructor
    }

    public static String generateText(ContactMessageDTO contactMessageDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Witaj " + contactMessageDTO.getFirstname() + " " + contactMessageDTO.getSecondname());
        stringBuilder.append(",\n\n");
        stringBuilder.append("Przyjelismy zgloszenie.");

        return stringBuilder.toString();
    }
}
