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
    CategoryFileInputValidator categoryFileInputValidator;

    public CategoryMapper() {
    }

    public Category toCategory(String input) throws WrongFileFormatExcetion {
        //TODO moj exception like wrongFileFormat Exception - i info ze oslugiwany format to long;String;long....

        if (categoryFileInputValidator.validate(input)) {
            String[] values = input.split(";");
            //TODO duze longi
            long id = Long.parseLong(values[0]);
            long parentId = Long.parseLong(values[1]);
            String text = values[2];
            String link = values[3];
            String linkToPicture = values[4];

            return new Category(id, parentId, text, link, linkToPicture);
        } else {
            throw new WrongFileFormatExcetion("File with categories has a wrong format error");
        }
    }
}
