package com.zygstore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.zygstore.business.mappers.CategoryDTOMapper;
import com.zygstore.business.mappers.CategoryMapper;
import com.zygstore.dto.CategoryDTO;
import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.CSVFileUtils;
import com.zygstore.utils.CategoryDTOHierarchyCreator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryService {
    private static final String MAIN_PAGE_BREADCRUMB_NAME = "Strona główna";

    private CategoryDTOHierarchyCreator categoryDTOHierarchyCreator;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private CategoryDTOMapper categoryDTOMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryDAO categoryDAO,
                           CategoryMapper categoryMapper,
                           CategoryDTOMapper categoryDTOMapper,
                           CategoryDTOHierarchyCreator categoryDTOHierarchyCreator) {
        this.categoryDAO = categoryDAO;
        this.categoryMapper = categoryMapper;
        this.categoryDTOMapper = categoryDTOMapper;
        this.categoryDTOHierarchyCreator = categoryDTOHierarchyCreator;
    }

    public List<CategoryDTO> getCategories() throws WrongFileFormatExcetion {
        List<Category> categories = categoryDAO.getAllCategories();
        return toCategoryDTOS(categories);
    }

    public List<CategoryDTO> getCategories(List<String> lines) {
        List<Category> categories = categoryMapper.toCategories(lines);

        return toCategoryDTOS(categories);
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

    private List<CategoryDTO> toCategoryDTOS(List<Category> categories) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOS.add(categoryDTOMapper.toCategoryDTO(category));
        }

        return categoryDTOHierarchyCreator.create(categoryDTOS);
    }
}
