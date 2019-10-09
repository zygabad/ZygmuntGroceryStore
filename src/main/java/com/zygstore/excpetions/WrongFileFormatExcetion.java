package com.zygstore.excpetions;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

public class WrongFileFormatExcetion extends RuntimeException {
    public static final String WRONG_NUMBER_OF_COLUMNS = "Line in the file has a wrong number of columns: '%s'. %d columns are expected.";
    public static final String WRONG_PARAMETER_TYPE = "Parameter '%s' has a wrong type. It should be %s.";

    private WrongFileFormatExcetion(String message) {
        super(message);
    }

    public static WrongFileFormatExcetion wrongNumberOfElements(String line, int expectedNumberOfColumns) {
        String message = String.format(WRONG_NUMBER_OF_COLUMNS, line, expectedNumberOfColumns);
        return new WrongFileFormatExcetion(message);
    }

    public static WrongFileFormatExcetion wrongParameterType(String parameter, String type) {
        String message = String.format(WRONG_PARAMETER_TYPE, parameter, type);
        return new WrongFileFormatExcetion(message);
    }
}