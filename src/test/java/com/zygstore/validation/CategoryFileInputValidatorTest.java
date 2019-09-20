package com.zygstore.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

public class CategoryFileInputValidatorTest {
    CategoryFileInputValidator categoryFileInputValidator = new CategoryFileInputValidator();

    //@Test(expected = Exception.class)//TODO konkretny wyjatek, przechwytuje tresc np wrongFormatExc... i ustawiam messydz co bylo zle
    public void testTooFewElements() {
       assertEquals(false, categoryFileInputValidator.validate("5;saf;343;43"));
    }

    @Test
    public void testTooManyElements() {
        assertEquals(false, categoryFileInputValidator.validate("5;saf;343;43;asdfa;3434"));
    }

    @Test
    public void testRightNumberOfElements() {
        assertEquals(true, categoryFileInputValidator.validate("5;saf;343;43;asdfa"));
    }

    @Test
    public void validateInputOneElementWithColon() {
        //given
        String input = "5;";

        //when
        boolean result = categoryFileInputValidator.validate(input);

        //then
        assertEquals(result, false);
    }
}