package com.zygstore.validation;

import static org.junit.Assert.assertTrue;

import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.utils.Constants;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

public class CategoryFileInputValidatorTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private CategoryFileInputValidator categoryFileInputValidator = new CategoryFileInputValidator();

    @Test
    public void testCorrectFormat() throws WrongFileFormatExcetion {
        String input = String.join(Constants.FILE_COLUMN_DELIMITER, "5", "5", "343", "43", "asdfa");
        categoryFileInputValidator.validate(input);
        assertTrue(true);
    }

    @Test
    public void testTooFewColumns() throws WrongFileFormatExcetion {
        // given
        String input = String.join(Constants.FILE_COLUMN_DELIMITER, "5", "saf", "343", "43");
        String errorMessage = String.format(WrongFileFormatExcetion.WRONG_NUMBER_OF_COLUMNS, input, Constants.CATEGORY_FILE_NUMBER_OF_COLUMNS);
        expectedException.expect(WrongFileFormatExcetion.class);
        expectedException.expectMessage(errorMessage);

        // when
        categoryFileInputValidator.validate(input);

        // then - exception
    }

    @Test
    public void testTooManyColumns() throws WrongFileFormatExcetion {
        // given
        String input = String.join(Constants.FILE_COLUMN_DELIMITER, "5", "saf", "343", "43", "asdfa", "3434");
        String errorMessage = String.format(WrongFileFormatExcetion.WRONG_NUMBER_OF_COLUMNS, input, Constants.CATEGORY_FILE_NUMBER_OF_COLUMNS);
        expectedException.expect(WrongFileFormatExcetion.class);
        expectedException.expectMessage(errorMessage);

        // when
        categoryFileInputValidator.validate(input);

        // then - exception
    }

    @Test
    public void testFirstElementWrongType() throws WrongFileFormatExcetion {
        // given
        String input = String.join(Constants.FILE_COLUMN_DELIMITER, "a", "saf", "343", "43", "asdfa");
        String errorMessage = String.format(WrongFileFormatExcetion.WRONG_PARAMETER_TYPE, "a", Constants.LONG_TYPE);
        expectedException.expect(WrongFileFormatExcetion.class);
        expectedException.expectMessage(errorMessage);

        // when
        categoryFileInputValidator.validate(input);

        // then - exception
    }

    @Test
    public void testSecondElementWrongType() throws WrongFileFormatExcetion {
        // given
        String input = String.join(Constants.FILE_COLUMN_DELIMITER, "1", "saf", "343", "43", "asdfa");
        String errorMessage = String.format(WrongFileFormatExcetion.WRONG_PARAMETER_TYPE, "saf", Constants.LONG_TYPE);
        expectedException.expect(WrongFileFormatExcetion.class);
        expectedException.expectMessage(errorMessage);

        // when
        categoryFileInputValidator.validate(input);

        // then - exception
    }

    @Test
    public void testSecondElementEmpty() throws WrongFileFormatExcetion {
        String input = String.join(Constants.FILE_COLUMN_DELIMITER, "5", Constants.NULL_ELEMENT, "343", "43", "asdfa");
        categoryFileInputValidator.validate(input);
        assertTrue(true);
    }
}