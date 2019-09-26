package com.zygstore.service;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.dto.CategoryDTO;
import com.zygstore.utils.CSVFileUtils;
import com.zygstore.utils.MenuItemsDTOSListCreator;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryService {
    private CSVFileUtils CSVFileUtils;

//    public ArrayList<MenuProductsDTO> getCategories(String filePath) {
//        ArrayList<String> linesFromFile = CSVFileUtils.getList(filePath);
//        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
//        ArrayList<MenuProductsDTO> listOfAllMenuItemsDTO = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);
//        ArrayList<MenuProductsDTO> listOfRootMenuItemsDTO = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, "null");
//
//        return listOfRootMenuItemsDTO;
//    }

    public List<CategoryDTO> getCategories(String filePath) {
        List<String> linesFromFile = CSVFileUtils.getList(filePath);
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        List<CategoryDTO> listOfAllMenuItemsDTO = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);
        List<CategoryDTO> listOfRootMenuItemsDTO = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, "null");

        return listOfRootMenuItemsDTO;
    }


    public List<CategoryDTO> getCategories(ArrayList<String> linesFromFile) {
        // TODO inject creator
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        List<CategoryDTO> listOfAllMenuItemsDTO = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);
        List<CategoryDTO> listOfRootMenuItemsDTO = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, "null");

        return listOfRootMenuItemsDTO;
    }

    public void setCSVFileUtils(CSVFileUtils CSVFileUtils) {
        this.CSVFileUtils = CSVFileUtils;
    }
}
