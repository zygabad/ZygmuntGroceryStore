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
        ArrayList<MenuProductsDTO> listOfRootMenuItemsDTO = getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, "0");

        return listOfRootMenuItemsDTO;
    }

    public ArrayList<MenuProductsDTO> getCategories(ArrayList<String> linesFromFile){
        ArrayList<MenuProductsDTO> listOfAllMenuItemsDTO = new ArrayList<>();
        ArrayList<MenuProductsDTO> listOfRootMenuItemsDTO = new ArrayList<>();
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
//        listOfAllMenuItemsDTO = getAllMenuItemsDTO(linesFromFile);
        listOfAllMenuItemsDTO = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);
        listOfRootMenuItemsDTO = getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, "0");

        return listOfRootMenuItemsDTO;
    }

    ArrayList<MenuProductsDTO> getSelectedMenuItemsDTO(ArrayList<MenuProductsDTO> listOfMenuItems, String parentId) {
        ArrayList<MenuProductsDTO> listOfSelectedMenuItems = new ArrayList<>();
        for (int i = 0; i < listOfMenuItems.size(); i++) {
            MenuProductsDTO currentMenuItemDTO = listOfMenuItems.get(i);
            if (currentMenuItemDTO.getParentId().equals(Long.parseLong(parentId))) {
                int j = 0;
                String currentItemID = Long.toString(currentMenuItemDTO.getID());
                List<MenuProductsDTO> childsList = getSelectedMenuItemsDTO(listOfMenuItems, currentItemID);
                currentMenuItemDTO.setChildsList(childsList);
                listOfSelectedMenuItems.add(j, currentMenuItemDTO);
                j++;
            }
        }

        Collections.reverse(listOfSelectedMenuItems);
        return listOfSelectedMenuItems;
    }


}
