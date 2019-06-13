package com.zygstore.utils;

import static org.junit.Assert.assertEquals;

import com.zygstore.excpetions.WrongIdException;
import com.zygstore.service.MenuProductsService;
import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class IdGeneratorTest {

    @Test
    public void testGenerateNewId() {

       // given
        IdGenerator idGenerator = new IdGenerator();

        // when
        Long id1 = idGenerator.generateNewId();
        Long id2 = idGenerator.generateNewId();
        Long id3 = idGenerator.generateNewId();

        // then
        assertEquals(IdGenerator.MINIMUM_START_ID, id1);
        assertEquals(Long.valueOf(2L), id2);
        assertEquals(Long.valueOf(3L), id3);
        assertEquals(Long.valueOf(4L), idGenerator.getId());
    }

    @Test(expected = WrongIdException.class)
    public void testGenerateNewIdThrowException() throws WrongIdException {
        // given
        IdGenerator idGenerator = new IdGenerator(0L);

        // when - expected exception

        // then - expected exception
    }

    @Test
    public void testGenerateNewIdFromStartPoint() throws WrongIdException {
        // given
        IdGenerator idGenerator = new IdGenerator(5L);

        // when
        Long id1 = idGenerator.generateNewId();
        Long id2 = idGenerator.generateNewId();
        Long id3 = idGenerator.generateNewId();

        // then
        assertEquals(Long.valueOf(5L), id1);
        assertEquals(Long.valueOf(6L), id2);
        assertEquals(Long.valueOf(7L), id3);
        assertEquals(Long.valueOf(8L), idGenerator.getId());
    }
}
