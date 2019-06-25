package com.zygstore.service;

import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

import com.zygstore.dto.MenuProductsDTO;
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
        assertEquals(Long.valueOf(1L), menuProductsDTO.getID());
        assertEquals(Long.valueOf(0L), menuProductsDTO.getParentId());
        assertEquals("Elektronika", menuProductsDTO.getText());
    }

    @Test
    public void getCategoriesInternetWay() {
        //given
        MenuProductsService menuProductsService = new MenuProductsService();
        ArrayList<String> linesFromFile = new ArrayList<>();
        linesFromFile.add("1;0;Elektronika;");
        linesFromFile.add("2;1;Telewizory;");

        //when
        ArrayList<MenuProductsDTO> result = menuProductsService.getCategories(linesFromFile);

        //then
        MenuProductsDTO menuProductsDTO = result.get(0);
        assertEquals(Long.valueOf(1L), menuProductsDTO.getID());
        assertEquals(Long.valueOf(0L), menuProductsDTO.getParentId());
        assertEquals("Elektronika", menuProductsDTO.getText());
    }

    @Test
    public void getSelectedMenuItems() {
        //given
        MenuProductsService menuProductsService = new MenuProductsService();
        ArrayList<String> linesFromFile = new ArrayList<>();
        linesFromFile.add("1;0;Elektronika;");
        linesFromFile.add("2;1;Telewizory;");
        ArrayList<MenuProductsDTO> listOfMenuProductDTOS = menuProductsService.getAllMenuItemsDTO(linesFromFile);

        //when
        ArrayList<MenuProductsDTO> result = menuProductsService.getSelectedMenuItemsDTO(listOfMenuProductDTOS,"1");

        //then
        MenuProductsDTO menuProductsDTO = result.get(0);
        assertEquals(Long.valueOf(2L), menuProductsDTO.getID());
        assertEquals(Long.valueOf(1L), menuProductsDTO.getParentId());
        assertEquals("Telewizory", menuProductsDTO.getText());
    }

    @Test
    public void getAllMenuItemsDTO() {
        //given
        MenuProductsService menuProductsService = new MenuProductsService();
        ArrayList<String> linesFromFile = new ArrayList<>();
        linesFromFile.add("1;0;Elektronika;");

        //when
        ArrayList<MenuProductsDTO> result = menuProductsService.getAllMenuItemsDTO(linesFromFile);

        //then
        MenuProductsDTO menuProductsDTO = result.get(0);
        assertEquals(Long.valueOf(1L), menuProductsDTO.getID());
        assertEquals(Long.valueOf(0L), menuProductsDTO.getParentId());
        assertEquals("Elektronika", menuProductsDTO.getText());
    }
}