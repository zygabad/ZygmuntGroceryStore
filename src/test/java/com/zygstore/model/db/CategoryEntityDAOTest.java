package com.zygstore.model.db;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.junit.Assert.assertEquals;

import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
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
 * @author Y08L@nykredit.dk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/zygstore/model/db/memoryDBTestContext.xml")
public class CategoryEntityDAOTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    CategoryDAO categoryDAO;

    @Test
    @DirtiesContext
    @Transactional
    public void testGetAllCategories() {
        //given
        Long id_1 = 1L;
        Long parentId_1 = 1L;
        String text_1 = "Elektronika";
        String linkToPicture_1 = "https://www.komputronik.pl/category/14508/elektronika.html;/images/categories/elektronika.jpg";
        createCategory(id_1, parentId_1, text_1, linkToPicture_1);

        Long id_2 = 2L;
        Long parentId_2 = 1L;
        String text_2 = "Komputery";
        String linkToPicture_2 = "https://www.komputronik.pl/category/14508/komputery.html;/images/categories/komputery.jpg";
        createCategory(id_2, parentId_2, text_2, linkToPicture_2);

        entityManager.flush();

        //when
        List<Category> categories = categoryDAO.getAllCategories();

        //then
        assertCategory(categories.get(0), id_1, parentId_1, text_1, linkToPicture_1);
        assertCategory(categories.get(1), id_2, parentId_2, text_2, linkToPicture_2);
    }

    private Category createCategory(Long id, Long parentId, String text, String linkToPicture) {
        Category category = new Category(id, parentId, text, linkToPicture);
        entityManager.persist(category);

        return category;
    }

    private void assertCategory(Category category, Long id, Long parentId, String text, String linkToPicture) {
        assertEquals(id, category.getId());
        assertEquals(parentId, category.getParentId());
        assertEquals(text, category.getText());
        assertEquals(linkToPicture, category.getLinkToPicture());
    }
}