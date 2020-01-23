package com.zygstore.utils;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;

import com.zygstore.dto.CategoryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class CategoryDTOHelperTest {

    @Autowired
    CategoryDTOHelper categoryDTOHelper;

    @Test
    public void testGetParent() {
        //given
        List<CategoryDTO> categories = new ArrayList<>();

        Long id_1 = 1L;
        Long parentId_1 = null;
        String text_1 = "Elektronika";
        String linkToPicture_1 = "/images/categories/elektronika.jpg";
        CategoryDTO categoryDTO_1 = new CategoryDTO(id_1, parentId_1, text_1, linkToPicture_1);

        Long id_2 = 2L;
        Long parentId_2 = id_1;
        String text_2 = "Laptopy";
        String linkToPicture_2 = "null";
        CategoryDTO categoryDTO_2 = new CategoryDTO(id_2, parentId_2, text_2, linkToPicture_2);

        categories.add(categoryDTO_1);
        categories.add(categoryDTO_2);

        //when
        CategoryDTO resultCategoryDTO = categoryDTOHelper.getParent(categories, 1L);

        //then
        assertEquals("Elektronika", resultCategoryDTO.getText());
    }

    @Test
    public void testMainPageDTO() {
        //given
        Long id_1 = 1L;
        Long parentId_1 = null;
        String text_1 = "Strona główna";
        String linkToPicture_1 = null;
        CategoryDTO categoryDTO_1 = new CategoryDTO(id_1, parentId_1, text_1, linkToPicture_1);

        //when
        CategoryDTO mainPageCategoryDTO = categoryDTOHelper.mainPageDTO();

        //then
        assertEquals(categoryDTO_1.getText(), mainPageCategoryDTO.getText());
    }
}