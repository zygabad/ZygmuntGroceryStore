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
            Long id = Long.parseLong(values[0]);
            Long parentId = null;
            if (!values[1].equals("null")) {
                parentId = Long.parseLong(values[1]);
            }
            String text = values[2];
            String linkToPicture = null;
            if (values.length > 3) {
                if (values[4].equals("null")) {
                    linkToPicture = getLinkToPicFromHref(values[3]);
                } else {
                    linkToPicture = values[4];
                }
            }
            CategoryDTO menuItemDTO = new CategoryDTO(id, parentId, text, linkToPicture);
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

            if ((parentId == null && currentMenuItemDTO.getParentId() == null) ||
                (parentId != null && parentId.equals(currentMenuItemDTO.getParentId()))) {
                int j = 0;
                Long currentItemID = currentMenuItemDTO.getId();
                List<CategoryDTO> childsList = getSelectedMenuItemsDTO(listOfMenuItems, currentItemID);
                currentMenuItemDTO.setChildsList(childsList);
                if (childsList.size() == 0) {
                    if (parentId == null) {
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
        Long id = 0L;
        Long parentId = null;
        String text = "MainPageDTO";
        String linkToPicture = null;
        CategoryDTO categoryDTO = new CategoryDTO(id, parentId, text, linkToPicture);

        List<String> breadcrumb = new ArrayList<>();
        breadcrumb.add(MAIN_PAGE_BREADCRUMB_NAME);
        categoryDTO.setBreadCrumbs(breadcrumb);

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
