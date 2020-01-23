package com.zygstore.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.zygstore.utils.CategoryDTOHierarchyCreator.*;
import static org.junit.Assert.*;

import com.zygstore.dto.CategoryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationTestContext.xml")
public class CategoryDTOHierarchyCreatorTest {

    @Autowired
    BreadCrumbsCreator breadCrumbsCreator;

    @Autowired
    CategoryDTOHelper categoryDTOHelper;

    @Autowired
    CategoryDTOHierarchyCreator categoryDTOHierarchyCreator;

    @Test
    public void testCreate() {
        CategoryDTO categoryDTO_1 = new CategoryDTO(1L, null, "Elektronika", "/images/categories/elektronika.jpg");
        CategoryDTO categoryDTO_2 = new CategoryDTO(2L, 1L, "Laptopy", null);
        CategoryDTO categoryDTO_3 = new CategoryDTO(184L, null, "Telefony i Smartwatche", "/images/telefonyIsmartwatche.jpg");
        CategoryDTO categoryDTO_4 = new CategoryDTO(185L, 184L, "Telefony i Smartfony", null);

        List<CategoryDTO> categories = Arrays.asList(categoryDTO_1, categoryDTO_2, categoryDTO_3, categoryDTO_4);

        //when
        List<CategoryDTO> mainCategories = categoryDTOHierarchyCreator.create(categories);

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