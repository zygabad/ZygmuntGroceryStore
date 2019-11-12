package com.zygstore.model.file;

import java.util.List;


import static org.junit.Assert.assertEquals;

import com.zygstore.business.mappers.CategoryMapper;
import com.zygstore.business.mappers.ProductMapper;
import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.CSVFileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */


//@RunWith(MockitoJUnitRunner.class)
//public class CategoryDAOFileImplTest {
//
//    @Mock
//    CategoryDAO categoryDAO;
//
//    @Spy
//    ProductMapper productMapper;
//
//    @Spy
//    CSVFileUtils csvFileUtils;
//
//    @Test
//    public void testGetAllCategories() throws WrongFileFormatExcetion {
//        //given
//
//        //when
//        List<Category> categoriesList = categoryDAO.getAllCategories();
//
//        //then
//        assertEquals(categoriesList.get(0).getText(), "Elektronika");
//    }
//}