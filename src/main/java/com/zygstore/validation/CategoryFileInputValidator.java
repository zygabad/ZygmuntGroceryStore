package com.zygstore.validation;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

public class CategoryFileInputValidator {

    public boolean validate(String input){

        if (input!= "" || input != " " ) {
            String[] values = input.split(";");
            if (values.length != 5) {
                return false;
            }
        }

        return true;
    }
}
