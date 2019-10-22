package com.zygstore.utils;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.dto.CategoryDTO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryDTOHierarchyCreator {
    public static final String MAIN_PAGE = "/index.xhtml";
    public static final String PRODUCTS_PAGE = "/viewProductsList.xhtml";
    public static final String CATEGORIES_PAGE = "/viewProductsCategories.xhtml";

    public List<CategoryDTO> create(List<CategoryDTO> categories) {
        updateChildren(categories);
        updateLinks(categories);

        return getMainCategories(categories);
    }

    private void updateChildren(List<CategoryDTO> categories) {
        for (CategoryDTO categoryDTO : categories) {
            CategoryDTO parent = getParent(categories, categoryDTO.getParentId());

            if (parent != null) {
                parent.getChildsList().add(categoryDTO);
            }
        }
    }

    private void updateLinks(List<CategoryDTO> categories) {
        for (CategoryDTO categoryDTO : categories) {
            if (categoryDTO.getParentId() == null) {
                categoryDTO.setLink(MAIN_PAGE);
            } else if (categoryDTO.getChildsList().size() > 0) {
                categoryDTO.setLink(CATEGORIES_PAGE);
            } else {
                categoryDTO.setLink(PRODUCTS_PAGE);
            }
        }
    }

    private List<CategoryDTO> getMainCategories(List<CategoryDTO> categories) {
        List<CategoryDTO> result = new ArrayList<>();

        for (CategoryDTO categoryDTO : categories) {
            if (categoryDTO.getParentId() == null) {
                result.add(categoryDTO);
            }
        }

        /*result = categories.stream()
            .filter(categoryDTO -> categoryDTO.getParentId() == null)
            .collect(Collectors.toList());*/

        return result;
    }

    private CategoryDTO getParent(List<CategoryDTO> categories, Long parentId) {
        for (CategoryDTO categoryDTO : categories) {
            if (parentId != null && parentId.equals(categoryDTO.getId())) {
                return categoryDTO;
            }
        }

        return null;
    }
}
