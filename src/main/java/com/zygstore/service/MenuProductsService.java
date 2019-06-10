package com.zygstore.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.zygstore.dto.MenuProductsDTO;
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
        ArrayList<MenuProductsDTO> listOfAllMenuItemsDTO = new ArrayList<>();
        ArrayList<MenuProductsDTO> listOfRootMenuItemsDTO = new ArrayList<>();
        listOfAllMenuItemsDTO = getAllMenuItemsDTO(linesFromFile);
        listOfRootMenuItemsDTO = getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, "0");

        return listOfRootMenuItemsDTO;
    }

    private ArrayList<MenuProductsDTO> getSelectedMenuItemsDTO(ArrayList<MenuProductsDTO> listOfMenuItems, String parentId) {
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

    private ArrayList<MenuProductsDTO> getAllMenuItemsDTO(ArrayList<String> linesFromFile) {
        ArrayList<MenuProductsDTO> menuItemsDTOList = new ArrayList<>();

        for (int i = 0; i < linesFromFile.size(); i++) {
            String line = linesFromFile.get(i);
            String[] values = line.split(";");
            MenuProductsDTO menuItemDTO = new MenuProductsDTO();
            menuItemDTO.setId(Long.parseLong(values[0]));
            menuItemDTO.setParentId(Long.parseLong(values[1]));
            menuItemDTO.setText(values[2]);
            menuItemDTO.setChildsList(null);
            menuItemDTO.setLink(null);
            menuItemsDTOList.add(i, menuItemDTO);
        }
        return menuItemsDTOList;
    }
}
