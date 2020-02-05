package com.zygstore.utils;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryDTOHierarchyCreator {
    public static final String PRODUCTS_PAGE = "/viewProductsList.xhtml";
    public static final String CATEGORIES_PAGE = "/viewProductsCategories.xhtml";

    @Autowired
    private BreadCrumbsCreator breadCrumbsCreator;

    @Autowired
    private CategoryDTOHelper categoryDTOHelper;

    public List<CategoryDTO> create(List<CategoryDTO> categories) {
        updateChildren(categories);
        updateLinks(categories);
        breadCrumbsCreator.updateBreadCrumbs(categories);
        return getMainCategories(categories);
    }

    private void updateChildren(List<CategoryDTO> categories) {
        for (CategoryDTO categoryDTO : categories) {
            CategoryDTO parent = categoryDTOHelper.getParent(categories, categoryDTO.getParentId());

            if (parent != null) {
                parent.getChildsList().add(categoryDTO);
            }
        }
    }

    private void updateLinks(List<CategoryDTO> categories) {
        for (CategoryDTO categoryDTO : categories) {
            if (categoryDTO.getParentId() == null) {
                categoryDTO.setLink(CATEGORIES_PAGE);
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

    public BreadCrumbsCreator getBreadCrumbsCreator() {
        return breadCrumbsCreator;
    }

    public void setBreadCrumbsCreator(BreadCrumbsCreator breadCrumbsCreator) {
        this.breadCrumbsCreator = breadCrumbsCreator;
    }
}
