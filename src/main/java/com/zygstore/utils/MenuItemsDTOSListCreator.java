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
            menuItemDTO.setId((values[0]));
            if (!values[1].equals("null")) {
                menuItemDTO.setParentId((values[1]));
            } else if (values[1].equals("null")) {
                menuItemDTO.setParentId("null");
            }
            menuItemDTO.setText(values[2]);
            menuItemDTO.setChildsList(null);
            if (values.length > 3) {
                menuItemDTO.setLink(values[3]);
            } else {
                menuItemDTO.setLink("/elektronika.xhtml");
            }
            menuItemsDTOList.add(i, menuItemDTO);
        }
        return menuItemsDTOList;
    }

    public ArrayList<MenuProductsDTO> getSelectedMenuItemsDTO(ArrayList<MenuProductsDTO> listOfMenuItems, String parentId) {
        ArrayList<MenuProductsDTO> listOfSelectedMenuItems = new ArrayList<>();
        for (int i = 0; i < listOfMenuItems.size(); i++) {
            MenuProductsDTO currentMenuItemDTO = listOfMenuItems.get(i);

            if (currentMenuItemDTO.getParentId().equals(parentId)) {
                int j = 0;
                String currentItemID = currentMenuItemDTO.getID();
                List<MenuProductsDTO> childsList = getSelectedMenuItemsDTO(listOfMenuItems, currentItemID);
                currentMenuItemDTO.setChildsList(childsList);
                listOfSelectedMenuItems.add(j, currentMenuItemDTO);

                MenuProductsDTO parent = findItem(listOfMenuItems, parentId);
                currentMenuItemDTO.setParent(parent);

                j++;
            }
        }

        Collections.reverse(listOfSelectedMenuItems);

        for (MenuProductsDTO dto : listOfMenuItems) {
            MenuProductsDTO parent = dto.getParent();
            List breadcrumbs = (parent != null) ? new ArrayList(parent.getBreadCrumbs()) : new ArrayList();
            breadcrumbs.add(dto.getText());
            dto.setBreadCrumbs(breadcrumbs);
        }

        return listOfSelectedMenuItems;
    }

    private MenuProductsDTO findItem(ArrayList<MenuProductsDTO> menuProductsDTOS, String id) {
        for (MenuProductsDTO dto : menuProductsDTOS) {
            if (dto.getID().equals(id)) {
                return dto;
            }
        }

        return null;
    }
}
