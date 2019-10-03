package com.zygstore.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.zygstore.dto.CategoryDTO;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

public class MenuItemsDTOSListCreator {
    private static final String MAIN_PAGE_BREADCRUMB_NAME = "Strona główna";

    public List<CategoryDTO> getAllMenuItemsDTO(List<String> linesFromFile) {
        List<CategoryDTO> menuItemsDTOList = new ArrayList<>();
        for (int i = 0; i < linesFromFile.size(); i++) {
            String line = linesFromFile.get(i);
            String[] values = line.split(";");
            CategoryDTO menuItemDTO = new CategoryDTO();
            menuItemDTO.setId(Long.parseLong(values[0]));
            if (!values[1].equals("null")) {
                menuItemDTO.setParentId(Long.parseLong(values[1]));
            } else if (values[1].equals("null")) {
                menuItemDTO.setParentId(null);
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
//TODO napisz test do tego creatora, zeby pokrywal menu glowne poziome i wyjdzie gdzie jest blad
    public List<CategoryDTO> getSelectedMenuItemsDTO(List<CategoryDTO> listOfMenuItems, Long parentId) {
        List<CategoryDTO> listOfSelectedMenuItems = new ArrayList<>();
        for (int i = 0; i < listOfMenuItems.size(); i++) {
            CategoryDTO currentMenuItemDTO = listOfMenuItems.get(i);
//            if (currentMenuItemDTO.getParentId().equals(parentId)) {
            if (currentMenuItemDTO.getParentId() == parentId) {
                int j = 0;
                Long currentItemID = currentMenuItemDTO.getId();
                List<CategoryDTO> childsList = getSelectedMenuItemsDTO(listOfMenuItems, currentItemID);
                currentMenuItemDTO.setChildsList(childsList);
                if (childsList.size() == 0) {
                    if (currentItemID == 0L) {
                        currentMenuItemDTO.setLink("/index.xhtml");
                    } else {
                        currentMenuItemDTO.setLink("/viewProductsList.xhtml");
                    }
                } else {
                    currentMenuItemDTO.setLink("/viewProductsCategories.xhtml");
                }
                listOfSelectedMenuItems.add(j, currentMenuItemDTO);

                CategoryDTO parent = findItem(listOfMenuItems, parentId);
                currentMenuItemDTO.setParent(parent);
                j++;
            }
        }
        Collections.reverse(listOfSelectedMenuItems);
        for (CategoryDTO dto : listOfMenuItems) {
            CategoryDTO parent = dto.getParent();
            List breadcrumbs = (parent != null) ? new ArrayList(parent.getBreadCrumbs()) : new ArrayList(mainPageDTO().getBreadCrumbs());
            breadcrumbs.add(dto.getText());
            dto.setBreadCrumbs(breadcrumbs);
        }

        return listOfSelectedMenuItems;
    }

    public CategoryDTO mainPageDTO() {
        CategoryDTO categoryDTO = new CategoryDTO();
        List<String> breadcrumb = new ArrayList<>();
        breadcrumb.add(MAIN_PAGE_BREADCRUMB_NAME);
        categoryDTO.setBreadCrumbs(breadcrumb);
        categoryDTO.setLink("/index.xhtml");
        categoryDTO.setId(0L);
        categoryDTO.setText("MainPageDTO");
        return categoryDTO;
    }


    private CategoryDTO findItem(List<CategoryDTO> categoryDTOS, Long id) {
        for (CategoryDTO dto : categoryDTOS) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }

        return null;
    }
}
