package com.zygstore.utils;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.dto.CategoryDTO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryDTOHelper {
    private static final String MAIN_PAGE_BREADCRUMB_NAME = "Strona główna";
    private static final String MAIN_PAGE_LINK = "/index.xhtml";

    public CategoryDTO getParent(List<CategoryDTO> categories, Long parentId) {
        for (CategoryDTO categoryDTO : categories) {
            if (parentId != null && parentId.equals(categoryDTO.getId())) {
                return categoryDTO;
            }
        }

        return null;
    }

    public CategoryDTO mainPageDTO() {
        Long id = 0L;
        Long parentId = null;
        String text = "Strona główna";
        String linkToPicture = null;
        CategoryDTO categoryDTO = new CategoryDTO(id, parentId, text, linkToPicture);

        List<String> breadcrumb = new ArrayList<>();
        breadcrumb.add(MAIN_PAGE_BREADCRUMB_NAME);
        categoryDTO.setBreadCrumbs(breadcrumb);
        categoryDTO.setLink(MAIN_PAGE_LINK);

        return categoryDTO;
    }
}
