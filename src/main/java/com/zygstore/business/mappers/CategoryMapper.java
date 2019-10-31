package com.zygstore.business.mappers;

import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.validation.CategoryFileInputValidator;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryMapper {
    private CategoryFileInputValidator categoryFileInputValidator;

    public CategoryMapper() {
    }

    public Category toCategory(String[] values) throws WrongFileFormatExcetion {
//TODO change input
        //        categoryFileInputValidator.validate(input);
        Long id = 0L;
        Long parentId = 0L;
        String text = null;
        String linkToPicture = null;

        if (!values[0].equals("null")) {
            id = Long.parseLong(values[0]);
        } else if (values[0].equals("null")) {
            id = null;
        }
        if (!values[1].equals("null")) {
            parentId = Long.parseLong(values[1]);
        } else if (values[1].equals("null")) {
            parentId = null;
        }
        text = values[2];
        linkToPicture = values[4];

        return new Category(id, parentId, text, linkToPicture);
    }
}
