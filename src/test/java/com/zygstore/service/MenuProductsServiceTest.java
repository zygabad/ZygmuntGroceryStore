package com.zygstore.service;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;

import com.zygstore.dto.MenuProductsDTO;
import com.zygstore.utils.MenuItemsDTOSListCreator;
import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class MenuProductsServiceTest {

    @Test
    public void getCategoriesFileWay() {
        //given
        MenuProductsService menuProductsService = new MenuProductsService();
        final String FILE_MENU_PRODUCTS = "Categories.csv";

        //when
        ArrayList<MenuProductsDTO> result = menuProductsService.getCategories(FILE_MENU_PRODUCTS);

        //then
        MenuProductsDTO menuProductsDTO = result.get(0);
        assertEquals("1", menuProductsDTO.getID());
        assertEquals("null", menuProductsDTO.getParentId());
        assertEquals("Elektronika", menuProductsDTO.getText());
    }

    @Test
    public void getCategoriesInternetWay() {
        //given
        MenuProductsService menuProductsService = new MenuProductsService();
        ArrayList<String> linesFromFile = new ArrayList<>();
        linesFromFile.add("1;null;Elektronika;");
        linesFromFile.add("2;1;Telewizory;");

        //when
        ArrayList<MenuProductsDTO> result = menuProductsService.getCategories(linesFromFile);

        //then
        MenuProductsDTO menuProductsDTO = result.get(0);
        assertEquals("1", menuProductsDTO.getID());
        assertEquals("null", menuProductsDTO.getParentId());
        assertEquals("Elektronika", menuProductsDTO.getText());
    }

    @Test
    public void getSelectedMenuItems() {
        //given
        MenuProductsService menuProductsService = new MenuProductsService();
        ArrayList<String> linesFromFile = new ArrayList<>();
        linesFromFile.add("1;null;Elektronika;");
        linesFromFile.add("2;1;Telewizory;");
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        ArrayList<MenuProductsDTO> listOfMenuProductDTOS =  menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);

        //when
        ArrayList<MenuProductsDTO> result = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuProductDTOS,"1");

        //then
        MenuProductsDTO menuProductsDTO = result.get(0);
        assertEquals("2", menuProductsDTO.getID());
        assertEquals("1", menuProductsDTO.getParentId());
        assertEquals("Telewizory", menuProductsDTO.getText());
    }

    @Test
    public void getAllMenuItemsDTO() {
        //given
        MenuProductsService menuProductsService = new MenuProductsService();
        ArrayList<String> linesFromFile = new ArrayList<>();
        linesFromFile.add("1;null;Elektronika;");

        //when
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        ArrayList<MenuProductsDTO> result = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);

        //then
        MenuProductsDTO menuProductsDTO = result.get(0);
        assertEquals("1", menuProductsDTO.getID());
        assertEquals("null", menuProductsDTO.getParentId());
        assertEquals("Elektronika", menuProductsDTO.getText());
    }

    @Test
    public void testBreadCrumbs(){
        MenuProductsService menuProductsService = new MenuProductsService();
        ArrayList<String> linesFromFile = new ArrayList<>();
        linesFromFile.add("1;null;Elektronika;");
        linesFromFile.add("2;1;Komputery;");
        linesFromFile.add("3;2;Laptopy;");

        //when
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        ArrayList<MenuProductsDTO> listOfMenuProductDTOS = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);
        ArrayList<MenuProductsDTO> result = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfMenuProductDTOS,"null");

        //then
        MenuProductsDTO menuLevel_1 = result.get(0);
        MenuProductsDTO menuLevel_2 = menuLevel_1.getChildsList().get(0);
        MenuProductsDTO menuLevel_3 = menuLevel_2.getChildsList().get(0);

        List breadCrumbsLevel_1 = menuLevel_1.getbreadCrumbs();
        List breadCrumbsLevel_2 = menuLevel_2.getbreadCrumbs();
        List breadCrumbsLevel_3 = menuLevel_3.getbreadCrumbs();

        assertEquals(1, breadCrumbsLevel_1.size());
        assertEquals("Elektronika", breadCrumbsLevel_1.get(0));

        assertEquals(2, breadCrumbsLevel_2.size());
        assertEquals("Elektronika", breadCrumbsLevel_2.get(0));
        assertEquals("Komputery", breadCrumbsLevel_2.get(1));

        assertEquals(3, breadCrumbsLevel_3.size());
        assertEquals("Elektronika", breadCrumbsLevel_3.get(0));
        assertEquals("Komputery", breadCrumbsLevel_3.get(1));
        assertEquals("Laptopy", breadCrumbsLevel_3.get(2));
    }
}