package com.zygstore.model.file;

import java.util.List;


import static org.junit.Assert.assertEquals;

import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.CSVFileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
//@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/webapp/WEB-INF/applicationTestContext.xml",
    "file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class CategoryDAOFileImplTest {
    @Autowired
    CategoryDAO categoryDAO;

    @Test
    public void testGetAllCategories() throws WrongFileFormatExcetion {
        //given

        //when
        List<Category> categoriesList = categoryDAO.getAllCategories();

        //then
        assertEquals(categoriesList.get(0).getText(), "Elektronika");
    }
}