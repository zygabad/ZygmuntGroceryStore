package com.zygstore.business.mappers;

import static org.junit.Assert.*;

import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryMapperTest {
    private CategoryMapper categoryMapper = new CategoryMapper();

    @Test
    public void testToCategory() throws WrongFileFormatExcetion {
        //given
        long id = 5L;
        String input = "" + id;

        //when
        Category category = categoryMapper.toCategory(input);

        //then
        assertEquals(id, category.getId());
    }
}