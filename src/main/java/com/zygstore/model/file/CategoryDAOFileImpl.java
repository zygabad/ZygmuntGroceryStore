package com.zygstore.model.file;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.business.mappers.CategoryMapper;
import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.CSVFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryDAOFileImpl implements CategoryDAO {
    private String categoriesFile;
    private CSVFileUtils CSVFileUtils;
    @Autowired
    private CategoryMapper categoryMapper;

    public void setCategoriesFile(String categoriesFile) {
        this.categoriesFile = categoriesFile;
    }

    public void setCSVFileUtils(CSVFileUtils CSVFileUtils) {
        this.CSVFileUtils = CSVFileUtils;
    }

    //TODO implement
    @Override
    public Category read(String categoryName) {
        throw new NotImplementedException();
    }

    //TODO implement
    @Override
    public List<Category> getCategories(String categoryId) {
        throw new NotImplementedException();
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        List<String> linesFromFile = CSVFileUtils.getList(categoriesFile);

        for (String line : linesFromFile) {
            if (!line.equals(null) || !line.equals("") || !line.equals(" ")) {
                String[] values = line.split(";");
                categoryList.add(categoryMapper.toCategory(values));
            }
        }
        return categoryList;
    }

    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;

    }
}
