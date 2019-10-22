package com.zygstore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.zygstore.business.mappers.CategoryDTOMapper;
import com.zygstore.dto.CategoryDTO;
import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.CSVFileUtils;
import com.zygstore.utils.CategoryDTOHierarchyCreator;
import com.zygstore.utils.MenuItemsDTOSListCreator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryService {
    private CSVFileUtils CSVFileUtils;
    private MenuItemsDTOSListCreator menuItemsDTOSListCreator;
    private CategoryDTOHierarchyCreator categoryDTOHierarchyCreator;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private CategoryDTOMapper categoryDTOMapper;

    public CategoryService(CategoryDAO categoryDAO,
                           CategoryDTOMapper categoryDTOMapper,
                           MenuItemsDTOSListCreator menuItemsDTOSListCreator,
                           CategoryDTOHierarchyCreator categoryDTOHierarchyCreator) {
        this.categoryDAO = categoryDAO;
        this.categoryDTOMapper = categoryDTOMapper;
        this.menuItemsDTOSListCreator = menuItemsDTOSListCreator;
        this.categoryDTOHierarchyCreator = categoryDTOHierarchyCreator;
    }

    public List<CategoryDTO> getCategories() throws WrongFileFormatExcetion {
        List<Category> categories = categoryDAO.getAllCategories();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOS.add(categoryDTOMapper.toCategoryDTO(category));
        }
//        return menuItemsDTOSListCreator.getSelectedMenuItemsDTO(categoryDTOS, null);
        return categoryDTOHierarchyCreator.create(categoryDTOS);
    }

    public List<CategoryDTO> getCategories(ArrayList<String> linesFromFile) {
        List<CategoryDTO> listOfAllMenuItemsDTO = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);
        List<CategoryDTO> listOfRootMenuItemsDTO = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, null);

        return listOfRootMenuItemsDTO;
    }

    public void setCSVFileUtils(CSVFileUtils CSVFileUtils) {
        this.CSVFileUtils = CSVFileUtils;
    }

}
