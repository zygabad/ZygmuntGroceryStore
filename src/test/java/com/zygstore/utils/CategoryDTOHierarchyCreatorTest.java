package com.zygstore.utils;

import java.util.ArrayList;
import java.util.List;


import static com.zygstore.utils.CategoryDTOHierarchyCreator.*;
import static org.junit.Assert.*;

import com.zygstore.dto.CategoryDTO;
import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryDTOHierarchyCreatorTest {

    @Test
    public void create() {
        CategoryDTOHierarchyCreator creator = new CategoryDTOHierarchyCreator();
        List<CategoryDTO> categories = new ArrayList<>();
        Long id_1 = 1L;
        Long parentId_1 = null;
        String text_1 = "Elektronika";
        String link_1 = MAIN_PAGE;
        String linkToPicture_1 = "/images/categories/elektronika.jpg";
        CategoryDTO categoryDTO_1 = new CategoryDTO(id_1, parentId_1, text_1, link_1, linkToPicture_1);

        Long id_2 = 2L;
        Long parentId_2 = id_1;
        String text_2 = "Laptopy";
        String link_2 = PRODUCTS_PAGE;
        String linkToPicture_2 = "null";
        CategoryDTO categoryDTO_2 = new CategoryDTO(id_2, parentId_2, text_2, link_2, linkToPicture_2);

        Long id_3 = 184L;
        Long parentId_3 = null;
        String text_3 = "Telefony i Smartwatche";
        String link_3 = MAIN_PAGE;
        String linkToPicture_3 = "/images/categories/telefonyIsmartwatche.jpg";
        CategoryDTO categoryDTO_3 = new CategoryDTO(id_3, parentId_3, text_3, link_3, linkToPicture_3);

        Long id_4 = 185L;
        Long parentId_4 = id_3;
        String text_4 = "Telefony i Smartfony";
        String link_4 = PRODUCTS_PAGE;
        String linkToPicture_4 = "null";
        CategoryDTO categoryDTO_4 = new CategoryDTO(id_4, parentId_4, text_4, link_4, linkToPicture_4);

        categories.add(categoryDTO_1);
        categories.add(categoryDTO_2);
        categories.add(categoryDTO_3);
        categories.add(categoryDTO_4);

        //when
        List<CategoryDTO> mainCategories = creator.create(categories);

        //done
        assertCategory(categoryDTO_1, mainCategories.get(0));
        assertCategory(categoryDTO_2, mainCategories.get(0).getChildsList().get(0));
        assertCategory(categoryDTO_3, mainCategories.get(1));
        assertCategory(categoryDTO_4, mainCategories.get(1).getChildsList().get(0));
    }

    private void assertCategory(CategoryDTO expected, CategoryDTO actual) {
        assertEquals(expected.getText(), actual.getText());
        assertEquals(expected.getLink(), actual.getLink());
    }
}