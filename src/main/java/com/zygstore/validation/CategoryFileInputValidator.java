package com.zygstore.validation;

import static com.zygstore.excpetions.WrongFileFormatExcetion.*;
import static com.zygstore.utils.Constants.*;

import com.zygstore.excpetions.WrongFileFormatExcetion;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

public class CategoryFileInputValidator {

    public void validate(String input) throws WrongFileFormatExcetion {
        String[] values = input.split(FILE_COLUMN_DELIMITER);

        if (values.length != CATEGORY_FILE_NUMBER_OF_COLUMNS) {
            throw wrongNumberOfElements(input, CATEGORY_FILE_NUMBER_OF_COLUMNS);
        }

        validateLong(values[0]);

        String parentId = values[1];
        if (!NULL_ELEMENT.equalsIgnoreCase(parentId)) {
            validateLong(parentId);
        }
    }

    private void validateLong(String parameter) throws WrongFileFormatExcetion {
        try {
            Long.parseLong(parameter);
        } catch (NumberFormatException e) {
            throw wrongParameterType(parameter, LONG_TYPE);
        }
    }
}
