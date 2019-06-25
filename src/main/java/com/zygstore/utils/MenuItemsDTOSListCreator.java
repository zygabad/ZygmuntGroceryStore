package com.zygstore.utils;

import java.util.ArrayList;


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
}
