package com.zygstore.service;

import java.util.ArrayList;


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
        MenuItemsDTOSListCreator menuItemsDTOSListCreator =new MenuItemsDTOSListCreator();
        ArrayList<MenuProductsDTO> result = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);

        //then
        MenuProductsDTO menuProductsDTO = result.get(0);
        assertEquals("1", menuProductsDTO.getID());
        assertEquals("null", menuProductsDTO.getParentId());
        assertEquals("Elektronika", menuProductsDTO.getText());
    }
}