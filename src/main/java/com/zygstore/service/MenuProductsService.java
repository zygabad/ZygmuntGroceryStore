package com.zygstore.service;

import java.util.ArrayList;


import com.zygstore.dto.MenuProductsDTO;
import com.zygstore.utils.MenuItemsDTOSListCreator;
import com.zygstore.utils.CSVFileUtils;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class MenuProductsService {
    private CSVFileUtils CSVFileUtils;

    public ArrayList<MenuProductsDTO> getCategories(String filePath) {
        ArrayList<String> linesFromFile = CSVFileUtils.getList(filePath);
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

    public void setCSVFileUtils(CSVFileUtils CSVFileUtils) {
        this.CSVFileUtils = CSVFileUtils;
    }
}
