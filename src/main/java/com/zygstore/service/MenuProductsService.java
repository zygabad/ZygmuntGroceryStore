package com.zygstore.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.zygstore.dto.MenuProductsDTO;
import com.zygstore.utils.MenuItemsDTOSListCreator;
import com.zygstore.utils.ReadCSVFileWithAllCategories;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class MenuProductsService {
    //@Autowired
    private static
    MenuProductsDTO menuProductsDTO;
    List<MenuProductsDTO> newMenuProductsItemsList;
    private ArrayList<String> linesFromFile = new ArrayList<>();

    public ArrayList<MenuProductsDTO> getCategories(String filePath) {
        ReadCSVFileWithAllCategories readCSVFileWithAllCategories = new ReadCSVFileWithAllCategories(filePath);
        linesFromFile = readCSVFileWithAllCategories.getList();
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        ArrayList<MenuProductsDTO> listOfAllMenuItemsDTO = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);
        ArrayList<MenuProductsDTO> listOfRootMenuItemsDTO = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, "null");

        return listOfRootMenuItemsDTO;
    }

    public ArrayList<MenuProductsDTO> getCategories(ArrayList<String> linesFromFile){
        ArrayList<MenuProductsDTO> listOfAllMenuItemsDTO = new ArrayList<>();
        ArrayList<MenuProductsDTO> listOfRootMenuItemsDTO = new ArrayList<>();
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        listOfAllMenuItemsDTO = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);
        listOfRootMenuItemsDTO = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, "null");

        return listOfRootMenuItemsDTO;
    }
}
