package com.zygstore.model.file;

import java.util.List;


import com.zygstore.business.mappers.CategoryMapper;
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
    //TODO consider to have a service instead of util
    private CSVFileUtils csvFileUtils;
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDAOFileImpl(CategoryMapper categoryMapper,
                               String categoriesFile,
                               CSVFileUtils csvFileUtils) {
        this.categoryMapper = categoryMapper;
        this.categoriesFile = categoriesFile;
        this.csvFileUtils = csvFileUtils;
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
        List<String> linesFromFile = csvFileUtils.getList(categoriesFile);

        return categoryMapper.toCategories(linesFromFile);
    }
}
