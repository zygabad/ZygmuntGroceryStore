package com.zygstore.business;

import java.util.Arrays;
import java.util.List;


import static com.zygstore.utils.CategoryDTOHierarchyCreator.CATEGORIES_PAGE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.zygstore.dto.CategoryDTO;
import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class AdminCacheBeanTest {

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AdminCacheBean adminCacheBean;

    @Test
    public void testCacheCleared() throws WrongFileFormatExcetion {
        //given
        Long id = 5L;
        Long parentId = null;
        String text = "Elektronika";
        String linkToPicture = "http://picture";

        Category category = new Category(id, parentId, text, linkToPicture);
        List<Category> categories = Arrays.asList(category);
        when(categoryDAO.getAllCategories()).thenReturn(categories);

        //when
        //first call - from file
        List<CategoryDTO> result = categoryService.getCategories();
        //cache cleared
        adminCacheBean.clearCache();
        //second call - also from file
        List<CategoryDTO> cachedResult = categoryService.getCategories();

        //then
        // Verification
        Mockito.verify(categoryDAO, Mockito.times(2)).getAllCategories();

        assertEquals(1, result.size());
        assertEquals(1, cachedResult.size());

        CategoryDTO categoryDTO = cachedResult.get(0);
        assertEquals(id, categoryDTO.getId());
        assertEquals(parentId, categoryDTO.getParentId());
        assertEquals(text, categoryDTO.getText());
        assertEquals(CATEGORIES_PAGE, categoryDTO.getLink());
        assertEquals(linkToPicture, categoryDTO.getLinkToPicture());
    }

}