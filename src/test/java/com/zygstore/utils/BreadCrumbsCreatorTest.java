package com.zygstore.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertEquals;

import com.zygstore.dto.CategoryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
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
public class BreadCrumbsCreatorTest {
    private static final String MAIN_PAGE = "Strona główna";
    private static final String ELECTRONICS = "Elektronika";
    private static final String LAPTOPS = "Laptopy";

    @Autowired
    CategoryDTOHelper categoryDTOHelper;

    @Autowired
    CategoryDTOHierarchyCreator categoryDTOHierarchyCreator;

    @Autowired
    BreadCrumbsCreator breadCrumbsCreator;

    @Test
    public void testUpdateBreadCrumbs() {
        //given
        CategoryDTO categoryDTO_1 = new CategoryDTO(1L, null, ELECTRONICS, null);
        CategoryDTO categoryDTO_2 = new CategoryDTO(2L, 1L, LAPTOPS, null);
        List<CategoryDTO> categories = Arrays.asList(categoryDTO_1, categoryDTO_2);

        //when
        breadCrumbsCreator.updateBreadCrumbs(categories);

        //then
        List<String> breadCrumbs = categoryDTO_1.getBreadCrumbs();
        assertEquals(2, breadCrumbs.size());
        assertEquals(MAIN_PAGE, breadCrumbs.get(0));
        assertEquals(ELECTRONICS, breadCrumbs.get(1));

        breadCrumbs = categoryDTO_2.getBreadCrumbs();
        assertEquals(MAIN_PAGE, breadCrumbs.get(0));
        assertEquals(ELECTRONICS,  breadCrumbs.get(1));
        assertEquals(LAPTOPS, breadCrumbs.get(2));
    }
}