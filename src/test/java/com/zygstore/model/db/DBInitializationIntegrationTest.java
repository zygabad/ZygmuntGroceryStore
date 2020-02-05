package com.zygstore.model.db;


import java.util.List;


import static org.junit.Assert.assertEquals;

import com.zygstore.model.Category;
import com.zygstore.model.Product;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.model.dao.ProductDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/zygstore/model/db/memoryDBTestContext.xml")
public class DBInitializationIntegrationTest {

    private static final int CATEGORIES_NUMBER = 1000;
    private static final int PRODUCTS_NUMBER = 5;

    @Autowired
    DBInitialization dbInitialization;

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    ProductDAO productDAO;

    @Test
    @DirtiesContext
    @Transactional
    public void testInitializeCategories() {
        //given
        List<Category> categoriesBefore = categoryDAO.getAllCategories();
        List<Product> productsBefore = productDAO.getAllProducts();

        //when
        dbInitialization.initialize();
        List<Category> categoriesAfter = categoryDAO.getAllCategories();
        List<Product> productsAfter = productDAO.getAllProducts();

        //then
        assertEquals(0, categoriesBefore.size());
        assertEquals(CATEGORIES_NUMBER, categoriesAfter.size());
        assertEquals(0, productsBefore.size());
        assertEquals(PRODUCTS_NUMBER, productsAfter.size());
    }
}