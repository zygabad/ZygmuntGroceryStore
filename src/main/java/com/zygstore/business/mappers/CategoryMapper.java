package com.zygstore.business.mappers;

import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.utils.Constants;
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

    public Category toCategory(String input) throws WrongFileFormatExcetion {
        categoryFileInputValidator.validate(input);
        String[] values = input.split(Constants.FILE_COLUMN_DELIMITER);
        //TODO duze longi
        long id = Long.parseLong(values[0]);
        long parentId = Long.parseLong(values[1]);
        String text = values[2];
        String link = values[3];
        String linkToPicture = values[4];

        return new Category(id, parentId, text, link, linkToPicture);
    }
}
