package com.zygstore.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.zygstore.dto.MenuProductsDTO;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

public class MenuItemsDTOSListCreator {

    public ArrayList<MenuProductsDTO> getAllMenuItemsDTO(ArrayList<String> linesFromFile) {
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

    public ArrayList<MenuProductsDTO> getSelectedMenuItemsDTO(ArrayList<MenuProductsDTO> listOfMenuItems, String parentId) {
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
