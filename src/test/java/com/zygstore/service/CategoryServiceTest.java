package com.zygstore.service;

import java.util.Arrays;
import java.util.List;


import static com.zygstore.utils.CategoryDTOHierarchyCreator.CATEGORIES_PAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import com.zygstore.business.mappers.CategoryDTOMapper;
import com.zygstore.business.mappers.CategoryMapper;
import com.zygstore.dto.CategoryDTO;
import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.CategoryDTOHierarchyCreator;
import com.zygstore.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @Mock
    private CategoryDAO categoryDAO;

    @Spy
    private CategoryMapper categoryMapper;

    @Spy
    private CategoryDTOMapper categoryDTOMapper;

    @Spy
    private CategoryDTOHierarchyCreator categoryDTOHierarchyCreator;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void getCategoriesFromFile() throws WrongFileFormatExcetion {
        //given
        Long id = 5L;
        Long parentId = null;
        String text = "Elektronika";
        String linkToPicture = "http://picture";

        Category category = new Category(id, parentId, text, linkToPicture);
        List<Category> categories = Arrays.asList(category);
        when(categoryDAO.getAllCategories()).thenReturn(categories);

        //when
        List<CategoryDTO> result = categoryService.getCategories();

        //then
        assertEquals(1, result.size());

        CategoryDTO categoryDTO = result.get(0);
        assertEquals(id, categoryDTO.getId());
        assertEquals(parentId, categoryDTO.getParentId());
        assertEquals(text, categoryDTO.getText());
        assertEquals(CATEGORIES_PAGE, categoryDTO.getLink());
        assertEquals(linkToPicture, categoryDTO.getLinkToPicture());
    }

    @Test
    public void testGetCategoriesFromLines() {
        //given
        String line = "1;null;Elektronika;https://www.komputronik.pl/category/14508/elektronika.html;http://picture";
        List<String> lines = Arrays.asList(line);

        //when
        List<CategoryDTO> result = categoryService.getCategories(lines);

        //then
        assertEquals(1, result.size());
        CategoryDTO categoryDTO = result.get(0);
        assertEquals(1, categoryDTO.getId().longValue());
        assertNull(categoryDTO.getParent());
        assertEquals("Elektronika", categoryDTO.getText());
        assertEquals(CATEGORIES_PAGE, categoryDTO.getLink());
        assertEquals("http://picture", categoryDTO.getLinkToPicture());
    }


    //TODO @Test
    public void testBreadCrumbs() {
        // given
        String categoryId_1 = "1";
        String categoryId_2 = "2";
        String categoryId_3 = "3";
        String mainCategoryName = "Strona główna";
        String categoryName_1 = "Elektronika";
        String categoryName_2 = "Komputery";
        String categoryName_3 = "Laptopy";

        String line_1 = String.join(Constants.FILE_COLUMN_DELIMITER, categoryId_1, Constants.NULL_ELEMENT, categoryName_1);
        String line_2 = String.join(Constants.FILE_COLUMN_DELIMITER, categoryId_2, categoryId_1, categoryName_2);
        String line_3 = String.join(Constants.FILE_COLUMN_DELIMITER, categoryId_3, categoryId_2, categoryName_3);

        List<String> linesFromFile = Arrays.asList(line_1, line_2, line_3);

        //when
//
        //then
////        CategoryDTO menuLevel_1 = result.get(0);
//        CategoryDTO menuLevel_2 = menuLevel_1.getChildsList().get(0);
//        CategoryDTO menuLevel_3 = menuLevel_2.getChildsList().get(0);
//
//        List breadCrumbsLevel_1 = menuLevel_1.getBreadCrumbs();
//        List breadCrumbsLevel_2 = menuLevel_2.getBreadCrumbs();
//        List breadCrumbsLevel_3 = menuLevel_3.getBreadCrumbs();
//
//        assertEquals(2, breadCrumbsLevel_1.size());
//        assertEquals(Arrays.asList(mainCategoryName, categoryName_1), breadCrumbsLevel_1);
//
//        assertEquals(3, breadCrumbsLevel_2.size());
//        assertEquals(Arrays.asList(mainCategoryName, categoryName_1, categoryName_2), breadCrumbsLevel_2);
//
//        assertEquals(4, breadCrumbsLevel_3.size());
//        assertEquals(Arrays.asList(mainCategoryName, categoryName_1, categoryName_2, categoryName_3), breadCrumbsLevel_3);
    }
}