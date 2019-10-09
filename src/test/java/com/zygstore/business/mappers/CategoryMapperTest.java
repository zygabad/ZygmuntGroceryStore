package com.zygstore.business.mappers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;

import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.utils.Constants;
import com.zygstore.validation.CategoryFileInputValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryMapperTest {
    @Mock
    private CategoryFileInputValidator validator;

    @InjectMocks
    private CategoryMapper categoryMapper = new CategoryMapper();

    @Test
    public void testToCategoryWithParent() throws WrongFileFormatExcetion {
        //given
        Long id = 5L;
        Long parentId = 1L;
        String text = "text";
        String link = "link";
        String linkToPicture = "linkToPicture";

        String input = String.join(Constants.FILE_COLUMN_DELIMITER, "" + id, "" + parentId, text, link, linkToPicture);
        String[] values = input.split(";");

        doNothing().when(validator).validate(anyString());

        //when
        Category category = categoryMapper.toCategory(values);

        //then
        assertEquals(id, category.getId());
        assertEquals(parentId, category.getParentId());
        assertEquals(text, category.getText());
        assertEquals(link, category.getLink());
        assertEquals(linkToPicture, category.getLinkToPicture());
    }
}