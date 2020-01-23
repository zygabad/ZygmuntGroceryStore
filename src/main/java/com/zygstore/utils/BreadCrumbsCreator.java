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

public class BreadCrumbsCreator {

    @Autowired
    private CategoryDTOHelper categoryDTOHelper;

    public void updateBreadCrumbs(List<CategoryDTO> categories) {
        for (CategoryDTO dtoCategory : categories) {
            Long parentId = dtoCategory.getParentId();
            CategoryDTO parent = categoryDTOHelper.getParent(categories, parentId);
            List breadcrumbs =
                (parent != null) ? new ArrayList(parent.getBreadCrumbs()) : new ArrayList(categoryDTOHelper.mainPageDTO().getBreadCrumbs());
            breadcrumbs.add(dtoCategory.getText());
            dtoCategory.setBreadCrumbs(breadcrumbs);
        }
    }
}
