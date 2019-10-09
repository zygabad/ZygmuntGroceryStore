package com.zygstore.service;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.business.mappers.CategoryDTOMapper;
import com.zygstore.dto.CategoryDTO;
import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.CSVFileUtils;
import com.zygstore.utils.MenuItemsDTOSListCreator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryService {
    private CSVFileUtils CSVFileUtils;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private CategoryDTOMapper categoryDTOMapper;

    public CategoryService(CategoryDAO categoryDAO, CategoryDTOMapper categoryDTOMapper) {
        this.categoryDAO = categoryDAO;
        this.categoryDTOMapper = categoryDTOMapper;
    }

    public List<CategoryDTO> getCategories() throws WrongFileFormatExcetion {
        List<Category> categories = categoryDAO.getAllCategories();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOS.add(categoryDTOMapper.toCategoryDTO(category));
        }
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        List<CategoryDTO> listOfRootMenuItemsDTO = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(categoryDTOS, null);

        return listOfRootMenuItemsDTO;
    }

    public List<CategoryDTO> getCategories(ArrayList<String> linesFromFile) {
        // TODO inject creator
        MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
        List<CategoryDTO> listOfAllMenuItemsDTO = menuItemsDTOSListCreator.getAllMenuItemsDTO(linesFromFile);
        List<CategoryDTO> listOfRootMenuItemsDTO = menuItemsDTOSListCreator.getSelectedMenuItemsDTO(listOfAllMenuItemsDTO, null);

        return listOfRootMenuItemsDTO;
    }

    public void setCSVFileUtils(CSVFileUtils CSVFileUtils) {
        this.CSVFileUtils = CSVFileUtils;
    }
}
