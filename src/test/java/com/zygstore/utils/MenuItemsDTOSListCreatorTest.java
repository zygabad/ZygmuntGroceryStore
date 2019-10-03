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
//        public CategoryDTO(Long id, Long parentId, String text, String link, String linkToPicture) {
        Long id = 1L;
        Long parentId = null;
        String text = "Elektronika";
        String link = "https://www.komputronik.pl/category/14508/elektronika.html";
        String linkToPicture = "/images/categories/elektronika.jpg";
        CategoryDTO categoryDTO_1 = new CategoryDTO(id, parentId, text, link, linkToPicture);

        Long id_2 = 3L;
        Long parentId_2 = 2L;
        String text_2 = "Laptopy";
        String link_2 = "https://www.komputronik.pl/category/5022/laptopy.html";
        String linkToPicture_2 = "null";
        CategoryDTO categoryDTO_2 = new CategoryDTO(id_2, parentId_2, text_2, link_2, linkToPicture_2);


        Long id_3 = 184L;
        Long parentId_3 =  null;
        String text_3 = "Telefony i Smartwatche";
        String link_3 = "https://www.komputronik.pl/category/9434/telefony.html";
        String linkToPicture_3 = "/images/categories/telefonyIsmartwatche.jpg";
        CategoryDTO categoryDTO_3 = new CategoryDTO(id_3, parentId_3, text_3, link_3, linkToPicture_3);

        Long id_4 = 185L;
        Long parentId_4 =  184L;
        String text_4 = "Telefony i Smartfony";
        String link_4 = "https://www.komputronik.pl/category/1596/smartfony.html";
        String linkToPicture_4 = "null";
        CategoryDTO categoryDTO_4 = new CategoryDTO(id_4, parentId_4, text_4, link_4, linkToPicture_4);

        listOfMenuItems.add(categoryDTO_1);
        listOfMenuItems.add(categoryDTO_2);
        listOfMenuItems.add(categoryDTO_3);
        listOfMenuItems.add(categoryDTO_4);

//        184;null;Telefony i Smartwatche;https://www.komputronik.pl/category/9434/telefony.html;/images/categories/telefonyIsmartwatche.jpg
//        185;184;Telefony i Smartfony;https://www.komputronik.pl/category/1596/smartfony.html;null


        //1;null;Elektronika;https://www.komputronik.pl/category/14508/elektronika.html;/images/categories/elektronika.jpg
//        2;1;Laptopy | Tablety;https://www.komputronik.pl/category/5803/laptopy-tablety.html;/images/categories/laptopyItablety.jpg
//        3;2;Laptopy;https://www.komputronik.pl/category/5022/laptopy.html;null
//

        //when
        List<CategoryDTO> result = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuItems, 2L);

        //done
        assertEquals(categoryDTO_1.getText(), menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuItems, null).get(0).getText());
        assertEquals(categoryDTO_2.getText(), menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuItems, 2L).get(0).getText());
        assertEquals(categoryDTO_3.getText(), menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuItems, null).get(1).getText());
        assertEquals(categoryDTO_4.getText(), menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuItems, 184L).get(0).getText());
    }

    @Test
    public void mainPageDTO() {
    }
}