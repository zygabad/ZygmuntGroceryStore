package com.zygstore.model.db;

import java.util.ArrayList;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.zygstore.business.mappers.CategoryMapper;
import com.zygstore.business.mappers.ProductMapper;
import com.zygstore.model.Category;
import com.zygstore.model.Product;
import com.zygstore.utils.CVSFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class DBInitialization {

    @PersistenceContext
    private EntityManager em;

    private CVSFileUtils cvsFileUtils;
    private String categoriesFile;
    private String productsFile;
    private CategoryMapper categoryMapper;
    private ProductMapper productMapper;

    private boolean dbInitialized = false;

    public DBInitialization(CVSFileUtils cvsFileUtils, String categoriesFile, CategoryMapper categoryMapper, String productsFile, ProductMapper productMapper) {
        this.cvsFileUtils = cvsFileUtils;
        this.categoriesFile = categoriesFile;
        this.categoryMapper = categoryMapper;
        this.productsFile = productsFile;
        this.productMapper = productMapper;
    }

    @Transactional
    public void initialize() {
        if (dbInitialized) {
            //Logger
            return;
        }
        initializeCategories();
        initializeProducts();
        dbInitialized = true;
    }

    private void initializeCategories() {
        List<String> linesFromFile = cvsFileUtils.getList(categoriesFile);
        List<Category> categories = categoryMapper.toCategories(linesFromFile);

        for (Category category : categories) {
            em.persist(category);
        }

        em.flush();
    }

    private void initializeProducts() {
        List<String> linesFromFile = cvsFileUtils.getList(productsFile);
        List<Product> products = toProducts(linesFromFile);

        for (Product product : products) {
            em.persist(product);
        }

        em.flush();
    }

    private List<Product> toProducts(List<String> linesFromFile) {
        List<Product> products = new ArrayList<>();

        for (String line : linesFromFile) {
            if (!line.equals(null) || !line.equals("") || !line.equals(" ")) {
                String[] values = line.split(";");

                if (values[2] != null && !values[2].equals("")) {
                    Product product = productMapper.toProduct(values);
                    products.add(product);
                }
            }
        }

        return products;
    }
}