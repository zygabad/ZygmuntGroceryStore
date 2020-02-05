package com.zygstore.model.file;

import java.util.List;


import com.zygstore.business.mappers.CategoryMapper;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.CVSFileUtils;
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
    private CVSFileUtils cvsFileUtils;
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDAOFileImpl(CategoryMapper categoryMapper,
                               String categoriesFile,
                               CVSFileUtils cvsFileUtils) {
        this.categoryMapper = categoryMapper;
        this.categoriesFile = categoriesFile;
        this.cvsFileUtils = cvsFileUtils;
    }

    //TODO implement
    @Override
    public Category read(String categoryName) {
        throw new NotImplementedException();
    }

    @Override
    public Category getCategory(Long categoryId) {
        throw new NotImplementedException();
    }

    @Override
    public List<Category> getAllCategories() {
        List<String> linesFromFile = cvsFileUtils.getList(categoriesFile);

        return categoryMapper.toCategories(linesFromFile);
    }
}
