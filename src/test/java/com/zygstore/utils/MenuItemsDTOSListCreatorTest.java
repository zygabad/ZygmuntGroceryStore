package com.zygstore.utils;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;

import com.zygstore.dto.CategoryDTO;
import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class MenuItemsDTOSListCreatorTest {

    @Test
    public void getAllMenuItemsDTO() {
    }

    @Test
    public void testGetSelectedMenuItemsDTO() {
        //given
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        List<CategoryDTO> listOfMenuItems = new ArrayList<>();
        Long id_1 = 1L;
        Long parentId_1 = null;
        String text_1 = "Elektronika";
        String link_1 = "https://www.komputronik.pl/category/14508/elektronika.html";
        String linkToPicture_1 = "/images/categories/elektronika.jpg";
        CategoryDTO categoryDTO_1 = new CategoryDTO(id_1, parentId_1, text_1, link_1, linkToPicture_1);

        Long id_2 = 2L;
        Long parentId_2 = id_1;
        String text_2 = "Laptopy";
        String link_2 = "https://www.komputronik.pl/category/5022/laptopy.html";
        String linkToPicture_2 = "null";
        CategoryDTO categoryDTO_2 = new CategoryDTO(id_2, parentId_2, text_2, link_2, linkToPicture_2);

        Long id_3 = 184L;
        Long parentId_3 = null;
        String text_3 = "Telefony i Smartwatche";
        String link_3 = "https://www.komputronik.pl/category/9434/telefony.html";
        String linkToPicture_3 = "/images/categories/telefonyIsmartwatche.jpg";
        CategoryDTO categoryDTO_3 = new CategoryDTO(id_3, parentId_3, text_3, link_3, linkToPicture_3);

        Long id_4 = 185L;
        Long parentId_4 = id_3;
        String text_4 = "Telefony i Smartfony";
        String link_4 = "https://www.komputronik.pl/category/1596/smartfony.html";
        String linkToPicture_4 = "null";
        CategoryDTO categoryDTO_4 = new CategoryDTO(id_4, parentId_4, text_4, link_4, linkToPicture_4);

        listOfMenuItems.add(categoryDTO_1);
        listOfMenuItems.add(categoryDTO_2);
        listOfMenuItems.add(categoryDTO_3);
        listOfMenuItems.add(categoryDTO_4);

        //when
        List<CategoryDTO> result_1 = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuItems, null);
        List<CategoryDTO> result_2 = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuItems, id_1);
        List<CategoryDTO> result_3 = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuItems, null);
        List<CategoryDTO> result_4 = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuItems, id_3);

        //done
        assertEquals(categoryDTO_1.getText(), result_1.get(0).getText());
        assertEquals(categoryDTO_2.getText(), result_2.get(0).getText());
        assertEquals(categoryDTO_3.getText(), result_3.get(1).getText());
        assertEquals(categoryDTO_4.getText(), result_4.get(0).getText());
    }

    @Test
    public void mainPageDTO() {
    }
}