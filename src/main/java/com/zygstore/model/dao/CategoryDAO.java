package com.zygstore.model.dao;

import java.util.List;


import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public interface CategoryDAO {
    public Category read(String categoryName);
    public List<Category> getCategories(String categoryId);
    public List<Category> getAllCategories();
}

