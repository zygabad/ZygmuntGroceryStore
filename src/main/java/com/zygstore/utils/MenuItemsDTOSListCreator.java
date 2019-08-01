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
    private static final String MAIN_PAGE_BREADCRUMB_NAME = "Strona główna";

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
                if (values[4].equals("null")) {
                    menuItemDTO.setLinkToPicture(getLinkToPicFromHref(values[3]));
                } else {
                    menuItemDTO.setLinkToPicture(values[4]);
                }
            } else {
                menuItemDTO.setLink("/viewProductsList.xhtml");
            }
            menuItemsDTOList.add(i, menuItemDTO);
        }

        return menuItemsDTOList;
    }

    private String getLinkToPicFromHref(String link) {
        String[] values = link.split("/");
        String categoryId = values[4];
        String imageLink = "https://www.komputronik.pl/uploads/category_pic_" + categoryId + ".jpg";
        return imageLink;
    }

    public ArrayList<MenuProductsDTO> getSelectedMenuItemsDTO(ArrayList<MenuProductsDTO> listOfMenuItems, String parentId) {
        ArrayList<MenuProductsDTO> listOfSelectedMenuItems = new ArrayList<>();
        for (int i = 0; i < listOfMenuItems.size(); i++) {
            MenuProductsDTO currentMenuItemDTO = listOfMenuItems.get(i);
            if (currentMenuItemDTO.getParentId().equals(parentId)) {
                int j = 0;
                String currentItemID = currentMenuItemDTO.getId();
                List<MenuProductsDTO> childsList = getSelectedMenuItemsDTO(listOfMenuItems, currentItemID);
                currentMenuItemDTO.setChildsList(childsList);
                if (childsList.size() == 0) {
                    if (currentItemID == "0") {
                        currentMenuItemDTO.setLink("/index.xhtml");
                    } else {
                        currentMenuItemDTO.setLink("/viewProductsList.xhtml");
                    }
                } else {
                    currentMenuItemDTO.setLink("/viewProductsCategories.xhtml");
                }
                listOfSelectedMenuItems.add(j, currentMenuItemDTO);

                MenuProductsDTO parent = findItem(listOfMenuItems, parentId);
                currentMenuItemDTO.setParent(parent);
                j++;
            }
        }
        Collections.reverse(listOfSelectedMenuItems);
        for (MenuProductsDTO dto : listOfMenuItems) {
            MenuProductsDTO parent = dto.getParent();
            List breadcrumbs = (parent != null) ? new ArrayList(parent.getBreadCrumbs()) : new ArrayList(mainPageDTO().getBreadCrumbs());
            breadcrumbs.add(dto.getText());
            dto.setBreadCrumbs(breadcrumbs);
        }

        return listOfSelectedMenuItems;
    }

    public MenuProductsDTO mainPageDTO() {
        MenuProductsDTO menuProductsDTO = new MenuProductsDTO();
        List<String> breadcrumb = new ArrayList<>();
        breadcrumb.add(MAIN_PAGE_BREADCRUMB_NAME);
        menuProductsDTO.setBreadCrumbs(breadcrumb);
        menuProductsDTO.setLink("/index.xhtml");
        menuProductsDTO.setId("0");
        menuProductsDTO.setText("MainPageDTO");
        return menuProductsDTO;
    }


    private MenuProductsDTO findItem(ArrayList<MenuProductsDTO> menuProductsDTOS, String id) {
        for (MenuProductsDTO dto : menuProductsDTOS) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }

        return null;
    }
}
