package com.zygstore.model.db;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.zygstore.business.mappers.CategoryMapper;
import com.zygstore.model.Category;
import com.zygstore.utils.CSVFileUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class DBInitialization {

    private CSVFileUtils csvFileUtils;
    private String categoriesFile;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    CategoryMapper categoryMapper;

    public DBInitialization(CSVFileUtils csvFileUtils, String categoriesFile, CategoryMapper categoryMapper) {
        this.csvFileUtils = csvFileUtils;
        this.categoriesFile = categoriesFile;
        this.categoryMapper = categoryMapper;
    }

    List<String> linesFromFile = csvFileUtils.getList(categoriesFile);
    List<Category> categories = categoryMapper.toCategories(linesFromFile);

    public void saveCategoriesToDB(List<Category> categories) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (Category category : categories) {
            em.persist(category);
        }
        tx.commit();
    }

}

